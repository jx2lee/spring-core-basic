package com.jx2lee.core.singleton;

//Eager Initialization
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("singleton 객체 로직 호출");
    }
}

// Static block initialization
//public class SingletonService {
//
//    private static SingletonService instance;
//    private SingletonService() {
//    }
//
//    static{
//        try{
//            instance = new SingletonService();
//        }catch(Exception e){
//            throw new RuntimeException("싱글톤 객체 생성 오류");
//        }
//    }
//
//    public static SingletonService getInstance() {
//        return instance;
//    }
//
//    public void logic() {
//        System.out.println("singleton 객체 로직 호출");
//    }
//}

// Lazy initialization
//public class SingletonService {
//
//    private static SingletonService instance;
//    private SingletonService() {
//    }
//
//    public static SingletonService getInstance() {
//        if(Objects.isNull(instance)) {
//            instance = new SingletonService();
//        }
//        return instance;
//    }
//
//    public void logic() {
//        System.out.println("singleton 객체 로직 호출");
//    }
//}

// Thread safe initialization
//public class SingletonService {
//
//    private static SingletonService instance;
//    private SingletonService() {
//    }
//
//    public static synchronized SingletonService getInstance() {
//        if(instance == null) {
//            instance = new SingletonService();
//        }
//        return instance;
//    }
//
//    public void logic() {
//        System.out.println("singleton 객체 로직 호출");
//    }
//}

// Double-Checked Locking
//public class SingletonService {
//
//    private static SingletonService instance;
//    private SingletonService() {
//    }
//
//    public static SingletonService getInstance() {
//        if(Objects.isNull(instance)) {
//            synchronized (SingletonService.class) {
//                if(Objects.isNull(instance)) {
//                    instance = new SingletonService();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public void logic() {
//        System.out.println("singleton 객체 로직 호출");
//    }
//}

// Bill Pugh Solution
//public class SingletonService {
//
//    private SingletonService() {
//    }
//
//    private static class SingletonServiceHelper{
//        private static final SingletonService INSTANCE = new SingletonService();
//    }
//
//    public static SingletonService getInstance() {
//        return SingletonServiceHelper.INSTANCE;
//    }
//
//    public void logic() {
//        System.out.println("singleton 객체 로직 호출");
//    }
//}
