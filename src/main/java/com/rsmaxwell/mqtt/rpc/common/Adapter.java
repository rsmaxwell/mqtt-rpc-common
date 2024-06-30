package com.rsmaxwell.mqtt.rpc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttCallback;
import org.eclipse.paho.mqttv5.client.MqttDisconnectResponse;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;

public class Adapter implements MqttCallback {

	private static final Logger logger = LogManager.getLogger(Adapter.class);

	public void messageArrived(String topic, MqttMessage replyMessage) throws Exception {
		logger.info("messageArrived");
	}

	public void disconnected(MqttDisconnectResponse disconnectResponse) {
		logger.info("disconnected");
	}

	public void mqttErrorOccurred(MqttException exception) {
		logger.info("mqttErrorOccurred");
	}

	public void deliveryComplete(IMqttToken token) {
		logger.info("deliveryComplete");
	}

	public void connectComplete(boolean reconnect, String serverURI) {
		logger.info("connectComplete");
	}

	public void authPacketArrived(int reasonCode, MqttProperties properties) {
		logger.info("authPacketArrived");
	}
}
