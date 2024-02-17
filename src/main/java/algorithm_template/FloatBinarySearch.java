package algorithm_template;

public class FloatBinarySearch {
    private double EPS = 1e-6;

    public double binarySearch(double l, double r) {
        while ((r - l) > EPS) {
            double mid = (r + l) / 2;
            if (check()) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return l;
    }

    public boolean check() {
        return true;
    }
}
