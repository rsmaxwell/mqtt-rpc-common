package com.rsmaxwell.mqtt.rpc.common;

import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttCallback;
import org.eclipse.paho.mqttv5.client.MqttDisconnectResponse;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adapter implements MqttCallback {

	private static final Logger log = LoggerFactory.getLogger(Adapter.class);

	@Override
	public void messageArrived(String topic, MqttMessage replyMessage) throws Exception {
		log.debug("messageArrived");
	}

	@Override
	public void disconnected(MqttDisconnectResponse disconnectResponse) {
		log.debug("disconnected");
	}

	@Override
	public void mqttErrorOccurred(MqttException exception) {
		log.debug("mqttErrorOccurred");
	}

	@Override
	public void deliveryComplete(IMqttToken token) {
		log.debug("deliveryComplete");
	}

	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
		log.debug("connectComplete");
	}

	@Override
	public void authPacketArrived(int reasonCode, MqttProperties properties) {
		log.debug("authPacketArrived");
	}
}
