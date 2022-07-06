package datastructure.stream;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));


        /**
         *【1】遍历/匹配（foreach/find/match）
         */
        List<Integer> list1 = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list1.stream().filter(x -> x > 6).forEach(System.out::println);

        // 匹配第一个
        Optional<Integer> findFirst = list1.stream().filter(x -> x > 6).findFirst();
        System.out.println("第一个符合的值：" + findFirst.get());

        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list1.parallelStream().filter(x -> x > 6).findAny();
        System.out.println("匹配任意一个值：" + findAny.get());

        // 是否包含符合特定条件的元素
        boolean anyMatch = list1.stream().anyMatch(x -> x < 6);
        System.out.println("是否存在大于6的值：" + anyMatch);


        /**
         *【2】筛选（filter）
         */
        List<String> list2 = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("高于8000的员工姓名：" + list2);


        /**
         *【3】聚合（max/min/count)
         */
        // 获取String集合中最长的元素
        List<String> list3 = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max1 = list3.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max1.get());

        // 获取Integer集合中的最大值
        List<Integer> list4 = Arrays.asList(7, 6, 9, 4, 11, 6);

        Optional<Integer> max2 = list4.stream().max(Integer::compareTo);
        System.out.println("自然排序的最大值：" + max2.get());

        Optional<Integer> max3 = list4.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自定义排序的最大值：" + max3.get());

        // 获取员工工资最高的人
        Optional<Person> max4 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最多的人是：" + max4.get().getName());

        // 计算Integer集合中大于6的元素的个数
        Long count = list1.stream().filter(x -> x > 6).count();
        System.out.println("list1中大于6的元素个数：" + count);


        /**
         *【4】映射(map/flatMap)
         */
        // 英文字符串数组的元素全部改为大写
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> list5 = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + list5);

        // 整数数组每个元素+3
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> list6 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + list6);

        // 将员工的薪资全部增加1000


    }
}
class Person {
    private String name;    // 姓名
    private int salary;     // 薪资
    private int age;        // 年龄
    private String sex;     //性别
    private String area;    // 地区

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}