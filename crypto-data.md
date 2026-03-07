Encrypt Data Java android Function
```java
private void encryptData()throws  Exception{
        String plainText="I Love You";
        byte[] plainTextByte=plainText.getBytes("UTF-8");

        String password="yKIkZeXTQ=9NWugO";//16 bit pass
        byte[] passwordByte=password.getBytes("UTF-8");

        SecretKeySpec secretKeySpec=new SecretKeySpec(passwordByte,"AES");

        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        byte[] securedBytes=cipher.doFinal(plainTextByte);

        String encodedString= Base64.encodeToString(securedBytes,Base64.DEFAULT);
        tvDisplay.setText(encodedString);

    }
```

