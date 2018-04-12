package main.java;

import com.mypurecloud.sdk.v2.extensions.notifications.NotificationEvent;
import com.mypurecloud.sdk.v2.extensions.notifications.NotificationListener;
import com.mypurecloud.sdk.v2.model.UserPresenceNotification;

class UserPresenceListener implements NotificationListener<UserPresenceNotification>{
	private String topic;
	private String userName;
	
	public Class<UserPresenceNotification> getEventBodyClass() {
		return UserPresenceNotification.class;
	}

	public String getTopic() {
		return topic;
	}

	public void onEvent(NotificationEvent<?> event) {
		String presence = ((UserPresenceNotification) event.getEventBody()).getPresenceDefinition().getSystemPresence();
		System.out.println("User: " + userName + "\t Presence: " + presence);
	}
	
	public UserPresenceListener(String userId, String userName) {
		this.userName = userName;
        this.topic = "v2.users." + userId + ".presence";
    }

}