package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

import org.jcodec.common.io.NIOUtils;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * A leaf box
 * 
 * A box containing data, no children
 * 
 * @author The JCodec project
 * 
 */
public class LeafBox extends Box {
    public static LeafBox createLeafBox(Header atom, ByteBuffer data) {
        LeafBox leaf = new LeafBox(atom);
        leaf.data = data;
        return leaf;
    }

    private ByteBuffer data;

    public LeafBox(Header atom) {
        super(atom);
    }

    public void parse(ByteBuffer input) {
        data = NIOUtils.read(input, (int) header.getBodySize());
    }

    public ByteBuffer getData() {
        return data.duplicate();
    }

    @Override
    protected void doWrite(ByteBuffer out) {
        NIOUtils.write(out, data);
    }
}
