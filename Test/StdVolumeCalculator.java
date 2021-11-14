public class StdVolumeCalculator {
    public static int getVolume(int length, int width, int height) {
        /**
         Generate date of the day after input

         * @param length Length of a cube
         * @param width Width of a cube
         * @param height Height of a cube
         * @return Volume of a cube
         */

        if (length<2||length>100 || width<5||width>200 || height<20||height>80) return 0;
        return length*width*height;
    }
}
