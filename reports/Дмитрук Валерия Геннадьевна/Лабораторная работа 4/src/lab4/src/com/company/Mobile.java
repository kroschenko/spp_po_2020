package com.company;

public class Mobile {
    private String model;
    private Parameters parameters;
    public Mobile() {
    }

    public Mobile(String model) {
        this.model = model;
    }

    public void getOperatingSystem() {
        if (this.model.toLowerCase().contains("iphone")) { System.out.println("This device works on iOS");
        } else {
            System.out.println("This device works on Android");
        }
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }


    public class Parameters {
        private String screen;
        private Integer memory;
        private Integer megapixels;
        private Integer ram;
        private Integer power;
        public	void getAllParameters()	{
            if	(this.screen != null &&	!this.screen.isEmpty()) {
                System.out.println("Screen resolution: " + this.screen + " px");
            }
            if	(this.memory != null) {
                System.out.println("Memory space: " + this.memory + " GB");
            }
            if (this.megapixels != null) {
                System.out.println("Camera: " + this.megapixels + " MP");
            }
            if (this.ram != null) {
                System.out.println("RAM: " + this.ram + " GB");
            }
            if (this.power != null) {
                System.out.println("Battery power: " + this.power + " MaH");
            }
        }

        public String getScreen() {
            return screen;
        }

        public void setScreen(String screen) {
            this.screen = screen;
        }

        public Integer getMemory() {
            return memory;
        }

        public void setMemory(Integer memory) {
            this.memory = memory;
        }

        public Integer getMegapixels() {
            return megapixels;
        }

        public void setMegapixels(Integer megapixels) {
            this.megapixels = megapixels;
        }

        public Integer getRam() {
            return ram;
        }

        public void setRam(Integer ram) {
            this.ram = ram;
        }

        public Integer getPower() {
            return power;
        }

        public void setPower(Integer power) {
            this.power = power;
        }
    }
}
