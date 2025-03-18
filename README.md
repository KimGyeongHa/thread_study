# process thread 

한개의 process내에는 한 개 이상의 thread가 반드시 존재해야한다.

## 스케줄링

	단일코어 스케줄링
	스케줄링큐에 여러개의 thread가 존재하며 돌아가며 실행
	
	멀티코어 스케줄링
	스케줄링 큐에 있는 thread를 여러개의 코어에서 실행

## 프로세스 
	실행중인 프로그램의 인스턴스

## 컨텍스트 스위칭
	thread 여러개 실행 시 이전에 실행하던 값의 주소를 기억하고
	다음 thread를 실행하다 다시 돌아올 떄 실행하던 주소값을
	기억하는 것을 의미한다.

## THREAD 작업 시 

	IO작업(데이터베이스 쿼리처리, 파일읽기/쓰기,네트워크 통신, 사용자 입력 처리)이 완료될 떄 까지 CPU는 사용하지않는다.
	
	작업 시 CPU보다 많은 thread를 생성해야 한다.
	
	thread 수 만큼 stack이 생성된다.
	
	daemonThread 는 user thread 사용 시 보조적인 일을 할 떄 사용한다.
	method가 모두 실행 시 daemonThread가 모두 실행되지 않아도 종료가 된다.
	
	Thread 상속보다 Runnable을 사용하는 것이 좋다.

	Thread가 runnable일떄 운영체제 스케줄링 상태
	1. 실행상태(running) : 스레드 cpu에서 실제로 실행 중
	2. 실행대기상태(ready) : 스레드가 준비되었지만, 스케줄링 큐에 대기중인상태

## THREAD 상태

	new : 스레드가 아직 실행되지 않은 상태
	runnable : 실행중이거나 실행 준비가 된 상태
	bocked : 동기화 락을 기다리는상태
	wating : 완료되기를 기다리는 상태
	timed_wating : 일정시간 기다리는 상태
	terminated : 실행을 마친상태

## THREAD JOIN

	이전 작업이 끝날 떄 까지 대기

## THREAD INTERRUPT

	실행중인 쓰레드를 강제적으로 종료하기 위하여 사용

 ## THREAD Yield

	Runnable 상태를 유지하면서 다른 thread에 우선권을 양보하며 강제성은 없다.
	JVM과 OS가 우선순위를 결정한다.

***

# THREAD시 이용하는 CLASS 또는 키워드

## java.util.concurrent

	동시성을 효율적으로 관리하기 위한 유틸리티를 제공하는 클래스


## volatile  

	여러 스레드가 동시에 접근할 때 사용하는 키워드

## Synchronized

	동시성 문제를 해결가능
	메모리 가시성 문제도 synchronized안에서는 해결됨.
	여러개의 쓰레드가 하나의 인스턴스에 접근 시 락을 먼저 가진 쓰레드에서 먼저 실행.

 ## ReentrantLock Class(LockSupport클래스가 내부동작에 활용 ) 

	lock interface를 상속받아 synchronized를 편하게 다룰 수 있는 구현체이다.

 	1. lock
  	thread가 실행 중이라면 다른 thread가 접근하지 못하게 해준다.
	
 	2. tryLock 
 	lock이 있는지 확인 후 없다면 획득 있으면 unlock, 매개변수를 통하여 시간을 줄 수도 있음.


***

# 메모리의 가시성

	한 스레드의 변경 값이 다른 스레드에 언제 반영되는가에 대한 문제
	주로 컨텍스트 스위칭이 일어나는 과정에서 반영되지만 100%는 아니다.
	
	volatile 캐시메모리에 접근하지 않고 메인메모리를 바로 사용하여 가시성 문제를 해결할 수 있다.
 
  ***

  # 임계영역

 	여러 스레드가 동시에 접근하면 데이터불일치나 예상치 못한 동작이
	발생할 수 있는 위험이 있는 코드부분
  
  # sleep, wait, notify

    sleep은 lock을 반납하지 않고 대기.

    wait는 lock을 반납 후 wating상태가 되며, notify를 통해 wating중인 값을 랜덤으로 꺠운다.

    notify는 해당 값이 로직이 실행여부에 상관없이 나와 비효율적으로 작동할 수 있으므로 notifyAll을 사용하여 기아문제 해결가능.

    notifyAll은 wating중인 모든 값을 blocked상태로 만들고 lock을 먼저 차지한 값이 작동하면 나머지는 wating으로, 미작동 시

    lock반납 후 blocekd상태가 됨.

 ***



 

