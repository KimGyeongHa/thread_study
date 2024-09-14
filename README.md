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
	
	Thread 상속보다 Runnable을 상속하여 사용하는 것이 좋다.

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

 
