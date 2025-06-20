package functional;


// 불변성 지향
public class immutabilityFunctional {

    public static void main(String[] args) {
        //
        ImmutabilityClass immutabilityClass1 = new ImmutabilityClass("불변");
        ImmutabilityClass immutabilityClass2 = immutabilityClass1.setName("불변");

       if (immutabilityClass1 == immutabilityClass2) {
           System.out.println("같음");
       }else System.out.println("다름");

    }


    static class ImmutabilityClass{
        private String name;

        public ImmutabilityClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public ImmutabilityClass setName(String name) {
            return new ImmutabilityClass(name);
        }


    }

}
