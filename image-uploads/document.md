if http use
```java
android:networkSecurityConfig="@xml/network_security_config"
android:usesCleartextTraffic="true"
```
res/xml/network_security_config
```java
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">13.250.207.14</domain>
    </domain-config>
</network-security-config>
```

internet Permission
```java
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
 
