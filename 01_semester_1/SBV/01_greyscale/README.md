# Greyscale

An RGB image consists of 3 channels, one channel for each basic color of the additive color space. If a certain pixel position is accessed, three scalar values are obtained:

$$g(3, 4) = (135, 100, 35)$$

The first value shows the intensity of the color red, the second that of the color green and the third that of the color blue. To access a specific color channel, the pixel position is extended by the specification of the respective color channel. Red is in color channel 0, green in channel 1 and blue in channel 2:

$$g(3, 4, 1) = (100)$$

The task is to convert these values into a grayscale image. Unlike RGB images, grayscale images provide only one scalar value per pixel position:

$$g(3, 4) = (90)$$

To achieve this, we discussed three methods in class:

**Mean method (average)**
  - Here, all scalar values of a pixel position of the RGB image are added and the sum is divided by the number of channels (RGB = 3 channels).

**Brightness method (lightness)**
  - Here, the highest and the lowest value from the three scalar values are determined and added. The sum is divided by two.

**Luminosity**
  - Here, the values of the three color channels are weighted differently, with the color green being assigned the largest share. The basis for this is human perception (0.21R, 0.72G, 0.07B). The values of the color channels are multiplied by the proportions and the results are summed.

In our implementation, we chose to implement the mean and brightness methods.
