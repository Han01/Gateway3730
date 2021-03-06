package com.ourselec.gateway.pc.message.serial.resolver;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.ourselec.gateway.pc.message.SensorModifyChannelResponseMessage;
import com.ourselec.gateway.pc.message.SensorModifyDeviceTypeResponseMessage;
/**
 * 传感器修改通道回复消息解析器
 * @author yangtianfei(ytf2737179@163.com)
 */
public class SensorModifyChannelRspMessageResolver extends
		SerialDataMessageResovler {

	public SensorModifyChannelRspMessageResolver(int source, int dataLen,
												 int code, byte[] buffer, int length) {
		super(source, dataLen, code, buffer, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object parsorMessage() {
		ByteBuffer bb = ByteBuffer.allocate(length);
		bb.put(buffer);
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.flip();

		int revResult = 0xff & bb.get();
		int checkNum = 0xff & bb.get();
		return new SensorModifyChannelResponseMessage(dataLen + 5, code,
				checkNum, revResult, 0x00, source);
	}

}