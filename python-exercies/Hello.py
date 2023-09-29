print(5)
print(3.14)
print(3+5)
print('풍선'*9)
print(5>10) 
print(not True)
# 애오나동물은 소개하 주세요~ 변수 

animal = "강이지"
name = "연탄이"
age = 4
hobby = "산책"
is_adult = age>=3

#print("우리 집 "+ animal +"의 이름은 " + name +"입니다" )
print("우리 집 ", animal,"의 이름은 ", name ,"입니다" )
print( name + "는 " +str(age)+ " 살이며, "+hobby+"를 아주 잘해요")
print(name + "는 어른 인가요 ? "+ str(is_adult))

# "#" 주석입니다. 

print(10//3)
print(not ( 1!=3))

print(abs(-5))
print(pow(4,2))
print(round(4.99)) # 반 올림 
print(round(3.14))

from math import *
print(floor(4.99)) # 내림 4
print(ceil(3.14)) #  올림 
print(sqrt(16)) #  제곱근

from random import * 
print(random( ) ) # 0.0 이상 ~ 1.0 미만의 임의 값 생성 
print(int(random( )*10) +1)  # 1~10 이하의 임의 값 생성  즉 10의 값만 변경하면 다 됩니다. 
print(randrange(1,45))  # 1이상 ~45 미만의 수입니다. 
print(randint(1,45)) # 양편넣기 1이상 45이하 

num = randint(4,28)
print("매월 오프라인 스터디 모임 날짜는 ? "+ str(num))


# string 

sentence = '나는 소년입니다.'
print(sentence)
sentence2 = "?"
print(sentence2)
sentence3 = """
나는 아주 쉬워요 
사랑해요 
"""
print(sentence3)

num = "123456-1234567"
# 슬아이실 자르ㅡ기 
print("성별 : "+ num[7] )
print("연 : " + num[0:2])
print(" ??? " + num[:5]) #시작부터 5직전 까지 
print("?? " + num[7:]) # 7부터 끝까지 
print(" 맨뒤에서 부터 7번째에서 "+ num[-7:])

python = "Python is aAmazing"
print (python.lower())
print(python[0].isupper())
print(len(python))
print(python.replace("Python","java"))
ind= python.index("n") # 없으면 오류이다. 
print(ind)
ind= python.index("n",ind+1) # ,뒤는 시작 위치  
print(ind)
find  = python.find("n") # 없으면 - 1 , 몇번쨰인지 
print(find)
cnt = python.count("n") #  몇번 등장핮는지 

print("da %d dasd %d, " %(20,10)) 
print("나는 {}살 {}입니다.".format(20,15))
print("나는 {1} 살 {0}살 입니다.".  format(23,12)) #변경가능 

print("나는 {num} 살 {agr}살 입니다.".  format( agr = 0,num = 10)) # 변경 가능.  

num2 = 10
num3 = " 히히"
print(f"{num2}, n\"um3") # \n \ 잇그케이프 
# \r: 커서를 맨 앞으로 이동합니다.  \b : 뺵스페이스 누르는 것과 동일 \T 탭역할  
print("Red Apple\rPine")

prob = "http://naver.com"
str1 =prob[7:]
num = str1.find(".")
str2 = str1[:num]

print(str2[:3]+str(len(str2))+str(str2.count("e")))



# 리스트 
print(" \n리스트\n")
# 지하철 칸별로 10 20 30  # 다양한 자료형 합쳐서 가능 
subway = [10.20,30]
subway.append(40)
subway.insert(1, 55)
subway.pop()
subway.sort() # 정렬가능
print(subway)
subway.reverse()
subway.clear()# 종료가능
subway = [ True, 20 , "하하하 "]

# dictionary
print(" \n사전\n") # 단어와 설명 중괄호 통한 데이터 입력 입니다. 

dic = {3:"유재석",100: "나 "}
print(dic)
print(dic[3]+" " +dic.get(100)) # 접근하는 2가지 방법 단  get 의 경우 키가 없으면 none 출력입니다. 
print( 3 in dic ) # 값이 있는지 확인 boolean

#dic = {"이휘":"유재석","호이디": "아아","하하":"하하"}
#dic["이휘"] = "히히"
#del dic["하하"] # 키 삭제 입니다. 
print(dic.keys())
#print(dic.values())
print(dic.items())


# 튜플 : 변경되지 않는 것 
print(" \n튜플\n") # 변경되지 않을떄 

menu =('돈까스', "치즈까트")
print(menu[1],menu[0])
(name,age,hobby) = ("김종국",20,"코딩")
print(name, age, hobby)


# 셋 :  
print(" \nSET\n") # 중복이 안되고 순서가 없다. 
my_set = {1,2,3,3,5}

# 교집합
java ={"유하","하하","호호호"}
python = set(["유재","하하","유하"])

print(java&python)
print(java.intersection(python))

#합집합

print(java | python)
print(java.union(python))


#차집합

print(java - python)
print(java.difference(python))



#자료구조의 변경 
print(" \n자료구조변경\n") 
menu = {"우류","커피","주스"}
print(menu,type(menu))
menu = list(menu)
print(menu,type(menu))
menu = set(menu)
print(menu,type(menu))
menu = tuple(menu)
print(menu,type(menu))



# 문제 
print(" \n문제\n") # 중복이 안되고 순서가 없다. 

# 랜덤으로 중복안되게 3명 뽀ㅃ끼 
from random import *
lst = range(1,21) # 1에서 20
lst = list(lst) # 타입을 변화해 줘야댐 
print(type(lst))
shuffle(lst) #썩기

win = sample(lst,4) # 4명뽀ㅃ끼 
print("커피 당첨자 {0}".format(win[0]))
print("치킨 {0}".format(win[1:]))

# 분기  if
print(" \n분기\n") # 상황별 내용 

weather = "눈"#input ("미세면지?") # input 값입력 대기 합수 string으로 값입멱딘다. 
if weather =="비" or weather =="눈":
    print("정답")
elif weather =="미세먼지" :
    print("먼지")
else :
    print("몰라")


temp = 11 #int(input("온도?"))
if temp ==10 :
    print ("10도")
elif 0<temp <=9 :
    print ("몰라")
else :
    print("온도가 이상해 ")

# for   while
print(" \nfor while\n") 

for wait in [1,2,3,4] :
    print("대기번호 : {0}".format(wait))


star = ["아이언맨", "토드","아이언","그루트"]
for cus in star :
    print("음료 ㄲ {0}".format(cus))
cus = "토르 "
index = 5
while index>=1:
    print("손님 {1}순ㅂ ㄱ {0}".format(cus,index))
    index-=1
st =[1,2,3,5,6]
st = [i+100 for i in st]
print(st)
st =["하이후에 ","나는 누구인가 ","그러게 누구인가 "]
st = [len(i) for i in st]
print(st)

# continue break
print(" \ncontinue break\n") 

ab =[2,5]
for st in range(1,11) :
    if(st in ab) :
        continue
    print("{0} 팩".format(st))


#문제 
ans =0
ind = 1
while ind<=50:
    num = randrange(5,51)
    if num >=5 and num<=15 :
        print("{0}번째 손님 (소요시간 :{1}".format(ind,num))
        ans+=1
    ind+=1
print("정답수 : "+ str(ans))

