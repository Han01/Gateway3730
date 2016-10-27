package com.ourselec.gateway.pc.message.serial.send;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.ourselec.gateway.message.MessageSend;
import com.ourselec.gateway.pc.message.PcModifyZbSensorChannelMessage;
import com.ourselec.gateway.pc.message.PcModifyZbSensorDeviceTypeMessage;
import com.ourselec.gateway.util.Utile;
/**
 * PC修改传感器通道消息发送器
 * @author yangtianfei(ytf2737179@163.com)
 */
public class PcModifyZbSensorChannelMessageSend extends MessageSend {

	public PcModifyZbSensorChannelMessageSend(Object message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] getMessageBuffer() {
		PcModifyZbSensorChannelMessage controlMessage = (PcModifyZbSensorChannelMessage) message;
		ByteBuffer bBuffer = ByteBuffer
				.allocate(controlMessage.getLength() - 2);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		bBuffer.put(controlMessage.getHead());
		bBuffer.put(Integer.valueOf(controlMessage.getLength()).byteValue());
		bBuffer.putShort(Integer.valueOf(controlMessage.getCommand())
				.shortValue());
		bBuffer.put(Integer.valueOf(controlMessage.getChannel()).byteValue());
		byte[] data = bBuffer.array();
		bBuffer.put(Utile.ort(data, 0, data.length - 1));

		bBuffer.rewind();
		byte[] buffer = new byte[bBuffer.remaining()];
		bBuffer.get(buffer);
		// this.mOutputStream.write(buffer);
		// this.mOutputStream.flush();
		return buffer;
	}

}