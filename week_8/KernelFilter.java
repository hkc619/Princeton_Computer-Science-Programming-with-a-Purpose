import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }
    //deal with 3

    public static Picture keranl3(Picture picture, double[][] weights) {
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rnew = 0.0;
        double gnew = 0.0;
        double bnew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        Color color = picture.get((w + col + i) % w , (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rnew += r * weights[i + 1][j + 1];
                        gnew += g * weights[i + 1][j + 1];
                        bnew += b * weights[i + 1][j + 1];
                    }
                }
                int R = (int) Math.round(rnew);
                int G = (int) Math.round(gnew);
                int B = (int) Math.round(bnew);
                if (R > 255) R = 255;
                if (G > 255) G = 255;
                if (B > 255) B = 255;
                if (R < 0) R = 0;
                if (G < 0) G = 0;
                if (B < 0) B = 0;
                Color newcolor = new Color(R, G, B);
                target.set(col, row, newcolor);
                rnew = 0.0;
                gnew = 0.0;
                bnew = 0.0;
            }
        }
        return target;
    }

    public static double[][] filter3(double[] array) {
        double[][] filter = new double[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                filter[i][j] = array[i * 3 + j];
            }
        }
        return filter;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[] array = {1.0 / 16.0, 2 / 16.0, 1 / 16.0, 2 / 16.0, 4 / 16.0, 2 / 16.0, 1 / 16.0, 4 / 16.0, 1 / 16.0};
        return keranl3(picture, filter3(array));
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[] array = {0, -1, 0, -1, 5, -1, 0, -1, 0};
        return keranl3(picture, filter3(array));
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[] array = {-1, -1, -1, -1, 8, -1, -1, -1, -1};
        return keranl3(picture, filter3(array));
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[] array = {-2, -1, 0, -1, 1, 1, 0, 1, 2};
        return keranl3(picture, filter3(array));
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            weights[i][i] = 1.0 / 9.0;
        }
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rnew = 0.0;
        double gnew = 0.0;
        double bnew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rnew += r * weights[i + 4][j + 4];
                        gnew += g * weights[i + 4][j + 4];
                        bnew += b * weights[i + 4][j + 4];
                    }
                }
                int R = (int) Math.round(rnew);
                int G = (int) Math.round(gnew);
                int B = (int) Math.round(bnew);
                if (R > 255) R = 255;
                if (G > 255) G = 255;
                if (B > 255) B = 255;
                if (R < 0) R = 0;
                if (G < 0) G = 0;
                if (B < 0) B = 0;
                Color newcolor = new Color(R, G, B);
                target.set(col, row, newcolor);
                rnew = 0.0;
                gnew = 0.0;
                bnew = 0.0;
            }
        }
        return target;

    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture id = identity(pic);
        id.show();

        Picture gaussian = gaussian(pic);
        gaussian.show();

        Picture sharpen = sharpen(pic);
        sharpen.show();

        Picture laplacian = laplacian(pic);
        laplacian.show();

        Picture emboss = emboss(pic);
        emboss.show();

        Picture motionBlur = motionBlur(pic);
        motionBlur.show();

    }
}
