package com.networknt.schema.perftest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by steve on 14/09/16.
 */
public class Runner {

    public static void main(final String[] args) {

        URL url = Runner.class.getClassLoader().getResource(Runner.class.getPackage().getName().replace(".", "/"));
        if (url == null) {
            throw new RuntimeException("Could not locate perf package");
        }
        final Map<String, Class> examples = new HashMap<String, Class>();
        //hackz to discover all the example classes on the class path
        ZipInputStream in = null;
        try {
            String zipPath = url.getPath().substring(0, url.getPath().indexOf("!")).replace("file:", "");
            in = new ZipInputStream(new FileInputStream(zipPath));
            ZipEntry entry = in.getNextEntry();
            while (entry != null) {
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().substring(0, entry.getName().length() - 6).replace("/", ".");
                    try {
                        Class<?> clazz = Class.forName(className);
                        PerfExample example = clazz.getAnnotation(PerfExample.class);
                        if (example != null) {
                            examples.put(example.value(), clazz);
                        }
                    } catch (Throwable e) {
                        //ignore
                    }
                }
                entry = in.getNextEntry();
            }

            final List<String> names = new ArrayList<String>(examples.keySet());
            Collections.sort(names);
            System.out.println("Welcome to the Perf Tests");
            System.out.println("Please select a test:");

            for (int i = 0; i < names.size(); ++i) {
                System.out.print((char) ('a' + i));
                System.out.println(") " + names.get(i));
            }
            byte[] data = new byte[1];
            System.in.read(data);

            String example = names.get(data[0] - 'a');
            System.out.println("Running example " + example);
            Class exampleClass = examples.get(example);
            PerfExample annotation = (PerfExample) exampleClass.getAnnotation(PerfExample.class);
            System.out.println("Please point your web browser at " + annotation.location());

            final Method main = exampleClass.getDeclaredMethod("main", String[].class);
            main.invoke(null, (Object)args);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(in != null) in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
