package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */
public class ClearApertureBox extends FullBox {
    protected float width;
    protected float height;

    public static String fourcc() {
        return "clef";
    }

    public static ClearApertureBox createClearApertureBox(int width, int height) {
        ClearApertureBox clef = new ClearApertureBox(new Header(fourcc()));
        clef.width = width;
        clef.height = height;
        return clef;
    }

    public ClearApertureBox(Header atom) {
        super(atom);
    }

    public ClearApertureBox(Header header, int width, int height) {
        super(header);
        this.width = width;
        this.height = height;
    }

    public void parse(ByteBuffer input) {
        super.parse(input);
        width = input.getInt() / 65536f;
        height = input.getInt() / 65536f;
    }

    protected void doWrite(ByteBuffer out) {
        super.doWrite(out);
        out.putInt((int) (width * 65536f));
        out.putInt((int) (height * 65536f));
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
