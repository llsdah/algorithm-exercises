from random import *

# 클래스  집합! 

#일반유닛 
class Unit : 
    def __init__(self,name,hp,speed): #__int__ 생성자 부분 최초 인식 입니다. 
        self.name = name
        self.hp = hp
        self.speed = speed
        print("{0} 유닛이 생성".format(self.name))
    
    def move (self,location) :
        print("움직인다. 지상")
        print("앞으로 {0}".format(self.speed))
    
    def demaged (self,demage):
        print ("공격 받음 {0}".format(self.name))
        self.hp -= demage
        if self.hp <= 0:
            print("ㅇ유닛이 파괴 되었다. ")

class AUnit(Unit): 
    def __init__(self,name,hp,speed, demage):
        Unit.__init__(self,name,hp,speed)
        self.demage = demage
        
    def attack(self,location):
        print("{0} 공격ㄱ : {1} 공격력 {2} ".format(self.name, location,self.demage))


wraith1 = AUnit("레이스",80,5,10)
print("유닛이름 입니다. {0} ,{1}.{2}".format(wraith1.name,wraith1.demage,wraith1.hp))
wraith1.clocking = True # 추가 변수 할당. 
wraith2 = AUnit("레이스",80,5,10)

if wraith1.clocking ==True:
    print("클로킬")

firebat1 = AUnit("파잉",50,16,10)
firebat1.attack("5시")

firebat1.demaged(25)
firebat1.demaged(25)

print()
# 상속  자식(부모)  이렇게 생성하면됩니다. 
# 다중상속  

class Flyable : 
    def __init__ (self,fly):
        self.fiy = fly
    def fly (self,name,location):
        print(" 날아 갑신다. {0} ".format(self.fiy))


class FlyableAUnit(AUnit,Flyable):
    def __init__(self, name, hp, demage,fly):
        AUnit.__init__(self,name, hp, 0,demage)
        Flyable.__init__(self,fly)
    
    def move(self,location) :
        print("공중 유닛 이동")
        self.fly(self.name,location)

valkyrie = FlyableAUnit("발키리",200,5, 6)
valkyrie.fly(valkyrie.name,"3시")

# 연산자 오버로딩  재정의 의미 !! 메소드 재정의  

vulture = AUnit("벌처",80,10,20)

battle = FlyableAUnit("배틀",500, 25, 3)

vulture.move("11시")
battle.fly(battle.name,"9시")
battle.move("12시")


#pass 일단은 완성된것처럼 넘어 간다 .
 
class Bg(Unit) :
    def __init__(self, name, hp, location):
        pass

suppy = Bg("서플라이",500,"7시")

def game_st():
    print("시작")

def game_over():
    pass


# super  () 붙이고 self는 없다 .
# 다중 상속의 경우 최초(맨앞의) 상속받은 것만 생성자 생성, 나머지는 따로 만들어야 댄다 .

class Buliding(Unit) :
    def __init__(self, name, hp, location):
        super().__init__(name,hp,0)
        self.location = location



# 실습
class Marine(AUnit):
    def __init__(self):
        AUnit.__init__(self,"마린",40,1,5)
    def stim(self):
        if self.hp >10:
            self.hp -=10
            print("스팀팩 사용")
        else :
            print("스팀팩 아남")


class Tank(AUnit):
    seize_devel = False

    def __init__(self):
        AUnit.__init__(self,"탱그",100,2,10)
        self.seizeMode = False

    def sizze(self):
        if Tank.seize_devel == False:
            return

        if self.seizeMode ==False:
            print("시즈모드 합니다.")
            self.demage *=2
            self.seizeMode =True
        else :
            print("시즈모드 아닙니다.")
            self.demage /=2
            self.seizeMode =False


class Wraith(FlyableAUnit):
    def __init__(self):
        FlyableAUnit.__init__(self,"레이스", 80, 2, 5)
        self.clocked = False

    def clocking(self) :
        if self.clocked == True:
            print("클로킬 해제 ")
            self.clocked = False
        else :
            print("클로킬 설정 ")
            self.clocked = True



def game_st():
    print("게임 시작")


def game_over():
    print("GG 사용자 퇴장 ")



# 게임 

game_st()
m1 = Marine()
m2 = Marine()
m3 = Marine()

t1 = Tank()
t2 = Tank()
t3 = Tank()

w1 = Wraith()

attck_Unit =[]
attck_Unit.append(m1)
attck_Unit.append(m2)
attck_Unit.append(m3)
attck_Unit.append(t1)
attck_Unit.append(t2)
attck_Unit.append(t3)
attck_Unit.append(w1)


for unit in attck_Unit:
    unit.move("1시")

Tank.seize_devel =True

for unit in attck_Unit :
    if isinstance(unit,Marine):
        unit.stim()
    elif isinstance(unit,Tank):
        unit.sizze()
    elif isinstance(unit,Wraith):
        unit.clocking()


for unit in attck_Unit :
    unit.attack("1시")

for unit in attck_Unit:
    unit.demaged(randint(5,21))

game_over()













