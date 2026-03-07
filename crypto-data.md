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


Decrypt Data Java

```java

 private void decryptData()throws Exception{

        String encodedString="upk5o7t/1ibXvqsZiyQDQA==";
        byte[] decodedByte= Base64.decode(encodedString,Base64.DEFAULT);

        String password="yKIkZeXTQ=9NWugO";//16 bit pass
        byte[] passwordByte=password.getBytes("UTF-8");
        SecretKeySpec secretKeySpec=new SecretKeySpec(passwordByte,"AES");


        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] decryptByte=cipher.doFinal(decodedByte);



        String plainText=new String(decryptByte,"UTF-8");



        tvDisplay.setText(plainText);
    }



```

Encrypt Data PHP

```php
<?php 

//Encrypt Data
$text="Maruf Hasan Mitul";
$encryped=openssl_encrypt($text,'AES-128-ECB','yKIkZeXTQ=9NWugO',OPENSSL_RAW_DATA);

$encoded=base64_encode($encryped);
echo $encoded;

?>
```

Decrypt  Data PHP

```php
<?php 

//Decrypt Data PHP

$encodedData="oMWCwNGj8F1WZgfjwWEKJ5g1K3hrVAcFHJjV7DGh//Q=";
$decoded=base64_decode($encodedData);
$decryped=openssl_decrypt($decoded,'AES-128-ECB','yKIkZeXTQ=9NWugO',OPENSSL_RAW_DATA);


echo $decryped;

?>
```





