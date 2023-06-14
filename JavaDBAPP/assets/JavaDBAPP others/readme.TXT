Bu programı Kadir Gökdeniz(20290344) ile beraber yaptık. Lab6 örneğine oldukça benzerdir ve temelinde filter kavramı üzerine
şekillenen bir programdır. Veritabanı uygulamasıdır ve girilen ya da sunucudan çekilen veriyi alıp onun üzerinde filtreleme yapılabilir.
Games.sql dosyası wampserver yüklemek gereklidir ben dosya adını dbconnection koymuştum eğer sunucu üzerinden farklı ad koyulursa bunun 
düzenlenmesi gerekir. Ayrıca id ve şifre kısmı farklıysa yine bu kısım da Dbconnector.java üzerinden düzenlenmelidir. Bazı kısımlarda 
sunucuya bağlanma hatası aldığım için sadece java connector 5.1.25 yerine son sürüm olan 8.0.17yi de ekledim ve herhangi bir sorun 
ile karşılaşmadım. URL yapısı biraz daha uzun ve farklı bunun sebeplerinden biri timezone uyuşmazlığıydı. 