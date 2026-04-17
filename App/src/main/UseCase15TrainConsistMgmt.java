package main;

public class UseCase15TrainConsistMgmt {

    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String msg) {
            super(msg);
        }
    }

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        void assignCargo(String cargo) {
            try {
                if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.print("");
            }
        }
    }
}