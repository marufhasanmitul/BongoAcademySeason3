```php
libxml_use_internal_errors(true);

$dom = new DOMDocument();
$dom->loadHTML($html);

libxml_clear_errors();
$xpath = new DOMXPath($dom);
$h1 = $dom->getElementsByTagName("h1")->item(0)->textContent;
echo $h1;
$title = $xpath->query("//h1")->item(0)->textContent;
$nodes = $xpath->query("//div[@class='news']");
$img = $xpath->query("//img")->item(0);
$src = $img->getAttribute("src");
$link = $xpath->query("//a")->item(0)->getAttribute("href");
$items = $xpath->query("//p");

foreach ($items as $p) {
    echo trim($p->textContent) . "\n";
}
$div = $xpath->query("//div[@class='news']")->item(0);
$h2  = $div->getElementsByTagName("h2")->item(0)->textContent;
//Clean text
$text = trim(preg_replace('/\s+/', ' ', $text));




$html = file_get_contents($url);

libxml_use_internal_errors(true);
$dom = new DOMDocument();
$dom->loadHTML($html);
libxml_clear_errors();

$xpath = new DOMXPath($dom);

//Api Output ar jonno

$data = [
    "title" => $title,
    "image" => $image,
    "content" => $paragraphs
];

echo json_encode($data, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);


```



