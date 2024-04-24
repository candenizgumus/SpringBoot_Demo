# Spring Anotasyonları

## @SpringBootApplication

Spring uygulamasında main metodun olduğu class üzerine yazılır. İçinde 3 farklı anotasyonu barındırır.

@SpringBootConfiguration : Bu sınıfın bir configurasayon sınıfı olduğunu belirtiyor.
@EnableAutoConfiguration : Otomatik configurasyonu etkinleştirir.
@ComponentScan : Spring projesi içindeki tüm componentleri tarar. @Component ile işaretli olan sınıflardan birer nesne örneğini spring application context'e ekler.
## @RestController 
Spring uygulamasında restful web servislerinin etkin olduğunu belirten anotasyondur.
@Controller'ın özelleşmiş bir versiyonudur. İçerisinde @COntrollerdan farklı olarak @ResponseBody anotasyonu vardır.
Genellikle JSON veya XML türünde veri dönecek API geliştirilmesinde kullanılır.
İçindeki her metod doğrudan HTTP yanıtı döndürür.
## @Controller
Spring MVC projelerinde kullanılabilir. Http isteklerini işler ve geriye sayfa döner.
HTML sayfasının serverda render edilmesini sağlar. @RestControllerla arasındaki fark: @RestController geriye Json değer dönmek için yazılırken, @Controller geriye HTML sayfasını döneceği zaman kullanılır.

### RequestMapping
Sınıf üzerinde kullanıldığında, dışarıdan gelen uygun isteğin o sınıfa yönlendirilmesini sağlar.
Metod üzerinde de kullanılabilirdi. Metod üzerinde kullanılırsa gelen isteğin metoda yönlendirilmesini sağlar.

@GetMapping @PostMapping gibi özelleşmiş varyasyonları da vardır. Sıkça da kullanılır.

### Parametreli istekler:

http://localhost:9090/selam5?ad=Deniz

@GetMapping("selam5")
public String selamVer5(String ad){
return "Selam5" + ad;
}

#### @RequestParam : Request ile gelen parametreleri metod parametrelerine aktarır.
Request : http://localhost/9090/selam6?ad=Deniz

@GetMapping("selam6")
public String selamVer6(@RequestParam(defaultValue = "Misafir") String ad){
return "Selam6" + ad;
}

#### @PathVariable: Request ile gelen / ifaesinden sonraki parametreyi metod parametresine aktarır.
Request: http://localhost/9090/selam/10
@GetMapping("selam/{selamID}")
public String selamVer7(@PathVariable Long selamID){
    return "Selam PathVariable " + selamID;
}

#### @RequestBody: Request body'sindeki verileri almak için kullanılır. Genelde Post işlemlerinde kullanılır. Body'deki veriden dönüşüm otomatik gerçekleştirilir. Body içindeki Json objesi, JACKSON kütüphanesi ile otomatik olarak Auth nesnesine dönüştürülmüştür.
@PostMapping("/selamVer8")
public String selamVer8(@RequestBody Auth auth){
return "Selam PostMapping! " + auth.getUsername();
}

## Response'lar:
### ResponseEntity: http response oluşturmak için kullanılır.
İçerisine veri, header ve status code eklenerek gönderilebilir.
    @GetMapping("/selamVer9")
    public ResponseEntity<String> selamVer9(){
        String mesaj = "Selam";
        HttpHeaders headers = new HttpHeaders();
        headers.add("key","value");
        headers.add("username","deniz123");
        return new ResponseEntity<>(mesaj,headers, HttpStatus.OK);
    }

### ResonseEntity.ok : Basit bir şekilde başarılı kodlu bir response dönmek için kullanılır.

@GetMapping("/selamVer10")
public ResponseEntity<String> selamVer10(){
return ResponseEntity.ok("Selam ok!");
}

## @Service: İçinde @Component anotasyonu vardır.
Genellikle business logic yazıldığı katmandır. Servis katmanı ile repository ve controller ile iletişimde olur.

## @Component : Bir sınıfın Spring bileşeni olduğunu belirtmek için kullanılır.
Spring @Component ile işaretli sınıfları otomatik olarak başlangıçta birer nesnelerini Spring Application Context'e ekler. Bu eklenen nesneler daha sonra projede herhangi bir sınıfa kolaylıkla  enjecte edilebilir.
@Component özelleşmiş versiyonları : @Repository ,@Service, @Controller anotasyonlarıdır.

