# Customer-RelationShip-Management

## Bu Proje, Login olmuş kullanıcıların Web'den veritabanıyla etkileşimde bulunmasını amaçlamaktadır. 
### Proje MVC Design Pattern kullanarak oluşturulmuştur.
### Projede iki farklı DataSource kullanılmıştır.  Primary olarak işaretlenen Employee DataSource'udur. Diğeri ise Validation'da kullanılan datasource'tur.

![Adsız45](https://user-images.githubusercontent.com/65908597/194726576-f9907bf5-0794-459f-b3e3-d6ad73d55389.png)


#### Uygulama ayağa kalktığında /showMyLoginPage uzantısına atılarak ilk olarak login sayfasıyla karşılaşılır.

![Adsız32](https://user-images.githubusercontent.com/65908597/194724451-2c5c8adf-b81b-4a6e-9690-5e5778184143.png)

#### Kullanıcılar aşağıdaki ilişkiye göre veritabanında depolanırlar 
* Her kullanıcının bir username'i,bir Kullanıcı rolü ve bicrypto şekilde şifrelenmiş bir şifresi vardır. Bu bilgiler kullanılarak login işlemleri yapılır
![Adsız33](https://user-images.githubusercontent.com/65908597/194724653-c29769ac-c26f-4fd9-bd44-a188b45a369b.png)


![Adsız36](https://user-images.githubusercontent.com/65908597/194725569-4c6e982d-b82e-4d65-b9e2-b95aad69e0ed.png)
![Adsız37](https://user-images.githubusercontent.com/65908597/194725594-17ced1bd-1845-4847-9021-8187b824b8e4.png)

#### Kullanıcı yanlış uygun olmayan bir bilgi girerse aşağıdaki errorla karşılaşır.
![Adsız34](https://user-images.githubusercontent.com/65908597/194725314-7cd7757d-a8f1-4f36-82da-ec3be2f3ca3e.png)

#### Kullanıcı bütün bilgileri doğru girerse /employees/list uzantısına gider ve kendi adını, rolünü ve üzerinde işlemler yapabileceği database'den çekilen; isimlerinin baş harflerine göre sıralanan Employee listesini görür.

![Adsız35](https://user-images.githubusercontent.com/65908597/194725531-ee2fd4c2-a72f-4ae0-b146-773e3b8a9ec1.png)
![Adsız38](https://user-images.githubusercontent.com/65908597/194725663-9bf31877-c811-4bf6-8a02-9bb7c314d9be.png)

#### Validation işlemlerinde ekstra mapping yapılmamıştır çünkü Spring Security belirli formatlarda oluşturulan veritabanı için otomatik mapping sağlamaktadır.

## BUTTONS

### 1-) Delete Butonu
  * Delete butonuna basılınca delete mapping(get request) çalışır(ilgili elemanın id'si servera yollanır) ve ilgili eleman database'den silinir ve sayfa yeniden yüklenir.(Artık 4 eleman var)
  
  ![Adsız39](https://user-images.githubusercontent.com/65908597/194725848-bb6a6970-2e97-42d7-a8f9-cb550efd2171.png)           
![Adsız40](https://user-images.githubusercontent.com/65908597/194725931-c8553648-0fc3-4d82-bf48-72cff564d885.png)

### 2-) Add Butonu 
#### Add Employee butonuna tıklandığında (servera get request yapılır) /showFormAdd uzantısına yönlendirilerek yeni Employee eklemek için aşağıdaki parametresiz sayfa oluşturulur.

![Adsız41](https://user-images.githubusercontent.com/65908597/194726065-bf08844e-aec3-49b8-a2ef-d17a31dc6742.png)

#### Veriler girilip Save butonuna tıklandığında(post request yapılır yani veriler modelde taşınarak servera gönderilir) kullanıcı ana sayfaya gönderilir ve yeni listeyi görür.

![Adsız42](https://user-images.githubusercontent.com/65908597/194726117-11b2574c-e216-4dcf-bfda-a31c9c3b8941.png)

![Adsız43](https://user-images.githubusercontent.com/65908597/194726174-8c85746a-7fa0-4e5f-9989-8a81af94ee24.png)            
![Adsız44](https://user-images.githubusercontent.com/65908597/194726178-c4369043-98be-414c-a91d-c52a7c2253ec.png)

### 3-) Update Butonu
#### Update butonuna tıklandığında servera get request yapılır ve aynı zamanda elemanın id'si servera yollanır. 
![Adsız47](https://user-images.githubusercontent.com/65908597/194726700-5687b6bc-c0fe-46f6-a656-89871e0f53ad.png)


