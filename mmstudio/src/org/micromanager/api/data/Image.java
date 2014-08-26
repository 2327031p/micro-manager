package org.micromanager.api.data;

import net.imglib2.meta.ImgPlus;

import mmcorej.TaggedImage;

/**
 * An Image is a single image plane with associated metadata. Functionally 
 * similar to TaggedImage, but with more rigidly-defined metadata and 
 * dataset positioning information.
 */
public interface Image {
   /**
    * Retrieve the ImgPlus that provides access to the image's pixel data.
    */
   public ImgPlus getPixels();

   /**
    * Generate a copy of this Image, except that its Coords object is at a
    * different location, as specified.
    */
   public Image copyAt(Coords coords);

   /**
    * Retrieve the intensity of the pixel at the specified position.
    */
   public double getIntensityAt(int x, int y);

   /**
    * Return a reference to whatever entity stores the actual pixel data for
    * this Image. Is most likely a byte[] or short[] but could be of any
    * non-primitive type.
    */
   public Object getRawPixels();
   /**
    * Retrieve the Metadata for this Image.
    */
   public Metadata getMetadata();

   /**
    * Retrieve the Coords for this Image.
    */
   public Coords getCoords();

   /**
    * For legacy support only: convert to TaggedImage;
    */
   public TaggedImage legacyToTaggedImage();
}
