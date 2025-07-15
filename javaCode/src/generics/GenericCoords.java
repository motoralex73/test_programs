package generics;

import java.util.Arrays;

public class GenericCoords {

    static class TwoD {
        int x, y;

        public TwoD(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class ThreeD extends TwoD {
        int z;

        public ThreeD(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }
    }

    static class FourD extends ThreeD {
        int w;

        public FourD(int x, int y, int z, int w) {
            super(x, y, z);
            this.w = w;
        }
    }

    static class Coords<T extends TwoD> {
        T[] coords;

        public Coords(T[] coords) {
            this.coords = coords;
        }
        public void showCoord() {
            for (T i : coords) System.out.println("x = " + i.x + ", y = " + i.y);
        }
    }

    static void showXY(Coords<?> c) {
            System.out.println("Координаты X Y:");
            for (int i = 0; i < c.coords.length; i++) {
                System.out.println("x = " + c.coords[i].x + ", y = " + c.coords[i].y);
            }
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("Координаты X Y Z:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println("x = " + c.coords[i].x + ", y = " + c.coords[i].y + ", z = " + c.coords[i].z);
        }
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("Координаты X Y Z W:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println("x = " + c.coords[i].x + ", y = " + c.coords[i].y + ", z = " + c.coords[i].z + ", w = " + c.coords[i].w);
        }
    }

    public static void main(String[] args) {
        TwoD[] two = {new TwoD(12,23), new TwoD(22,33)};
        ThreeD[] three = {new ThreeD(11,22,33)};
        FourD[] four = {new FourD(1, 2, 3, 4)};

        showXY(new Coords<>(two));
        showXYZ(new Coords<>(three));
        showAll(new Coords<>(four));

        showXY(new Coords<>(three));
        showXY(new Coords<>(four));
    }
}
