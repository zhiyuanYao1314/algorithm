package alibaba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/30 13:04
 * Describe:
 * version:1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String path = "/home/a.log";

        System.out.println("-------从指定文件中查找包含字符串'abc'的行--------");
        String containedStr = "abc";
        test2.cat(path, containedStr);

        System.out.println("-------从指定文件中查找符合正则表达式的行----------");
        String regex = ".*abc.*";
        Pattern p = Pattern.compile(regex);
        test2.cat(path, p);
    }

    /**
     * 从给定的文件中找到所有包含指定字符串的行，打印出来，并进行去重和排序。
     * @param path         指定的文件路径
     * @param containedStr 希望被包含的字符串
     */
    public void cat(String path, String containedStr) {
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line = null;
            // treeset可以进行排序和去重
            Set<String> set = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                if (line.contains(containedStr)) set.add(line);
            }
            // 显示符合条件的字符串行
            for (String str : set) {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("读取文件有问题");
        }
    }

    /**
     * 从给定的文件中找到符合指定正则表达式的行，打印出来，并进行去重和排序。
     *
     * @param path    指定的文件路径
     * @param pattern 正则表达式模式
     */
    public void cat(String path, Pattern pattern) {
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line = null;
            Set<String> set = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                if (m.matches()) {
                    set.add(line);
                }
            }
            for (String str : set) {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("读取文件有问题");
        }
    }
}
