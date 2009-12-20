package luzi82.guripassword;

import java.security.SecureRandom;
import java.util.Random;

public class GpRandom extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1376513105157706151L;

	public static final int BUFFER_SIZE = 10000;

	private final SecureRandom secureRandom = new SecureRandom();

	private final byte[] buffer = new byte[BUFFER_SIZE];

	private int bufferWritePosition = 0;

	private int bufferReadPosition = 0;

	private byte feedByteBuffer = 0;

	private int feedPosition = 0;

	public GpRandom() {
	}

	protected int next(int bits) {
		return (secureRandom.nextInt() ^ nextIntFromBuffer()) >>> (32 - bits);
	}

	public void feedBit(int bit) {
		if ((bufferWritePosition + 1) % BUFFER_SIZE == bufferReadPosition)
			return;
		feedByteBuffer <<= 1;
		feedByteBuffer |= (bit & 1);
		feedPosition++;
		if (feedPosition >= Byte.SIZE) {
			buffer[bufferWritePosition++] = feedByteBuffer;
			bufferWritePosition %= BUFFER_SIZE;
			feedPosition = 0;
		}
	}

	private int nextIntFromBuffer() {
		int ret = 0;
		for (int i = 0; i < Integer.SIZE; i += Byte.SIZE) {
			ret |= nextByte();
			ret <<= Byte.SIZE;
		}
		return ret;
	}

	private byte nextByte() {
		if (bufferWritePosition == bufferReadPosition) {
			byte[] ret = new byte[1];
			secureRandom.nextBytes(ret);
			return ret[0];
		} else {
			byte ret = buffer[bufferReadPosition++];
			bufferReadPosition %= BUFFER_SIZE;
			return ret;
		}
	}

	public int storedByte() {
		int ret = bufferWritePosition - bufferReadPosition;
		if (ret < 0)
			ret += BUFFER_SIZE;
		return ret;
	}

}
