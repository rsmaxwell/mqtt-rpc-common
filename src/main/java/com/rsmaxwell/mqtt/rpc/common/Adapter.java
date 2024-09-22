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

	private static final Logger log = LogManager.getLogger(Adapter.class);

	public void messageArrived(String topic, MqttMessage replyMessage) throws Exception {
		log.debug("messageArrived");
	}

	public void disconnected(MqttDisconnectResponse disconnectResponse) {
		log.debug("disconnected");
	}

	public void mqttErrorOccurred(MqttException exception) {
		log.debug("mqttErrorOccurred");
	}

	public void deliveryComplete(IMqttToken token) {
		log.debug("deliveryComplete");
	}

	public void connectComplete(boolean reconnect, String serverURI) {
		log.debug("connectComplete");
	}

	public void authPacketArrived(int reasonCode, MqttProperties properties) {
		log.debug("authPacketArrived");
	}
}
