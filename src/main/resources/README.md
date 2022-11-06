# ProjectManagementSystem
Environment variables
dbPassword=password;dbusername=username

Зарплата(сума) всіх розробників окремого проєкта:
  util -s projectId
  
Список розробників окремого проєкта:
  developer -fAp projectId
  
Список всіх Java-розробників:
  developer -fAlg Java
  
Список всіх middle-розробників:
  developer -fAlv Middle
  
Cписок проєктів в наступному форматі: дата створення - назва проєкта - 
кількість розробників на цьому проєкті:
  project -fa
