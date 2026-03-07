```php
<?php

$image = $_POST['image'];

$decoded = base64_decode($image);

$file = "uploads/img_" . time() . ".jpg";

if(!file_exists("uploads")){
    mkdir("uploads",0777,true);
}

if(file_put_contents($file,$decoded)){
	echo 'Image Upload Successfully';
    
}else{
	echo 'Image Upload Faild';
   
}

?>


