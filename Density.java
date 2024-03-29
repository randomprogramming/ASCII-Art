enum Density {
    DENSITY("\"`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$\"");

    private final String density;

    Density(String density){
        this.density = density;
    }
    char getDensityFor(int value){
        //Get a char depending on the brightness value
        //Since we dont have 255 chars, have to get the char using percentages
        double percent = this.density.length() / 255.0;
        int charValue = (int) (Math.round(percent * value));
        if(charValue<0){
            charValue = 0;
        }
        else if(charValue >= this.density.length()){
            charValue = this.density.length() - 1;
        }
        return this.density.charAt(charValue);
    }
}