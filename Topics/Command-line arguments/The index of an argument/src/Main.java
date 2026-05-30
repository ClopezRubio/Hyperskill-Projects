class Problem {
    public static void main(String[] args) {

        int helper = 0;
        boolean condition = false;

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("test")){
                helper = i;
                condition = true;
            }
        }

        if(condition == true){
            System.out.println(helper);
        }else{
            System.out.println("-1");
        }
    }
}