# Thread 시작

## 스케줄링

	단일코어 스케줄링
	스케줄링큐에 여러개의 thread가 존재하며 돌아가며 실행
	
	멀티코어 스케줄링
	스케줄링 큐에 있는 thread를 여러개의 코어에서 실행

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

	해당 THREAD 작업이 끝날 떄 까지 대기

## THREAD INTERRUPT

	실행중인 쓰레드를 강제적으로 종료하기 위한 신호를 보내는 메서드

 ## THREAD Yield

	Runnable 상태를 유지하면서 다른 thread에 우선권을 양보하며 강제성은 없다.
	JVM과 OS가 우선순위를 결정한다.

***

## 메모리의 가시성

	한 스레드의 변경 값이 다른 스레드에 언제 반영되는가에 대한 문제
	주로 컨텍스트 스위칭이 일어나는 과정에서 반영되지만 100%는 아니다.
	
	volatile 캐시메모리에 접근하지 않고 메인메모리를 바로 사용하여 가시성 문제를 해결할 수 있다.
    단, 복합 연산에 관한 값은 보장되지 않음.

## volatile

	여러 스레드가 동시에 접근할 때 사용하는 키워드

## Synchronized

	동시성 문제를 해결가능
	메모리 가시성 문제도 synchronized안에서는 해결됨.
	여러개의 쓰레드가 하나의 인스턴스에 접근 시 락을 먼저 가진 쓰레드에서 먼저 실행.
 	Monitor lock 사용
 
***

  ## 임계영역

 	여러 스레드가 동시에 접근하면 데이터불일치나 예상치 못한 동작이
	발생할 수 있는 위험이 있는 코드부분
  
***

  ## Monitor lock 사용 시 sleep, wait, notify

    sleep은 lock을 반납하지 않고 대기.

    wait는 lock을 반납 후 wating상태가 되며, notify를 통해 wating중인 값을 랜덤으로 꺠운다.

    notify는 해당 값이 로직이 실행여부에 상관없이 나와 비효율적으로 작동할 수 있으므로 notifyAll을 사용하여 기아문제 해결가능.

    notifyAll은 wating중인 모든 값을 blocked상태로 만들고 lock을 먼저 차지한 값이 작동하면 나머지는 wating으로, 미작동 시

    lock반납 후 blocekd상태가 됨.

  ## ReentrantLock Class(LockSupport 클래스가 내부동작에 활용 ), Condition 객체

	lock interface를 상속받아 synchronized를 편하게 다룰 수 있는 구현체이다.

 	1. lock
  	thread가 실행 중이라면 다른 thread가 접근하지 못하게 해준다.
	
 	2. tryLock 
 	lock이 있는지 확인 후 없다면 획득 있으면 unlock, 매개변수를 통하여 시간을 줄 수도 있음.

    Conditon
    wait(), notify() 유사한 기능을 제공
    await(), signal(), signalAll() 사용으로 스레드 간 통신을 제어하는 객체

***

  ## 동시성 Collection

    1. Collections.synchronizedXXX
      syncronized블록을 사용하여 전체 lock이 걸려서 느리다.
    
    2. concurrent 패키지 동시성 패키지
      
      빠른 읽기 (List) -> CopyOnWriteArrayList
      작은 Set, 변경 적음 ->  CopyOnWriteArraySet
      빠른 큐 (락 없음) ->  ConcurrentLinkedQueue
      크기 제한 큐 ->  ArrayBlockingQueue
      빠른 Map (해시 기반) -> ConcurrentHashMap
      정렬된 Map 필요 -> ConcurrentSkipListMap
  
   ## java.util.concurrent
	동시성을 효율적으로 관리하기 위한 유틸리티를 제공하는 클래스

***
  ## Executor 프레임워크
    
    멀티스레딩 작업을 쉽게 관리하고 비동기 작업을 처리하기 위해 제공되는 스레드 풀 기반의 API
    
    shutdown() → 새로운 작업을 받지 않도록 하고, 기존 작업이 끝날 때까지 기다림.
    awaitTermination(timeout) → 일정 시간 동안 Executor가 종료되기를 기다림.
    shutdownNow() → 실행 중인 작업을 강제 종료 시도 (하지만 즉시 종료되는 건 아님).

    interrupt를 받을 수 없는 로직은 강제종료 해주어야함.

    Callable 사용하여 Future 객체로 return값을 반환 받을 수 있음.
    Future get() 사용 시 blocking이 된다.

# ExecutorService Thread Pool 전략

    Thread Pool Executor 설정값

    new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.xxx, workQueue, RejectHandler)
    를 사용하여 사용자 정의로 제어가능

    corePoolSize ->	풀에서 항상 유지되는 최소 스레드 개수
    maximumPoolSize ->	풀에서 허용하는 최대 스레드 개수
    keepAliveTime -> corePoolSize 초과 스레드가 유휴 상태일 때 제거되기 전까지의 대기 시간
    workQueue -> 대기열 크기, 대기할 수 있는 작업 개수를 결정

    1. 고정 풀 전략

    newFixedThreadPool 내부
    new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())

    newFixedThreadPool로 pool size를 고정하여 pool size보다 초과 한 값은 queue에 대기 후 실행
    이용자가 늘어날 시 대기시간 증가

    2. 캐시 풀 전략

    newCachedThreadPool 내부
    new ThreadPool(0, Integer.MAX_VALUE, 60L, Times.SECONDS, new SynchronousQueue<Runnable>())
    최소 스레드 풀 크기를 정하지 않고 모든 값은 새로운 스레드를 풀에 만들고 실행,
    모든 작업 종료 시 정해진 시간동안 작업이 생성되지 않으면 스레드 풀에 적재된 스레드 제거
    이용자가 늘어날 시 서버과부화 위험


    3. 단일 스레드 전략

    newSingleThreadExecutor -> 단일 스레드 사용 시 이용, 순차적 처리에 사용

    4. 스케줄링 전략

    newScheduledThreadPool -> 주기적으로 처리해야할 값이 있을때 사용

    5. 사용자 정의 풀 전략

    CPU 사양에 맞게 pool size, queue size 조정 후 pool size 초과 시 queue에 대기 queue초과 시 
    maximum pool size 까지 가동, maximum pool size 와 queue size 초과 시 
    RejectedExecutionException으로 예외처리.
    queue 사이즈 미지정으로 인한 오류조심.


  ## Callable

    runnable과 같이 멀티 스레드 안의 작업을 정의하는데 이용

    1. runnable과 다르게 return값이 존재.
    2. exception을 받을 수 있음.
    
***
## ExecutorService RejectHandler(오류제어)

    AbortPolicy -> default값으로 모든 size 초과 시 RejectedExecutionException발생
    CallerRunsPolicy -> RejectedExecutionException 대신 해당 일을 시킨 thread가 대신해서 일을하게함. 
    사용자 정의 -> RejectedExecutionHandler를 상속받아 재정의하여 사용.
***

# CompletableFuture

    Java의 비동기 처리 API

    👉 Future의 한계를 보완하고, 비동기 작업을 체이닝(연결)하여 쉽게 다룰 수 있도록 한 클래스.
    👉 멀티스레드 환경에서 비동기 작업을 수행하고, 콜백을 체이닝하여 가독성을 높이는 데 사용.
    👉 ForkJoinPool 또는 Exectuor를 활용하여 특정 thread pool 이용가능
   

## 시작

    👉runAsync

      1. 결과값이 필요하지 않은 비동기 작업에 사용
      2. runnable을 인자로 받으며 return값이 존재하지 않음.
    
    👉supplyAsync

      1. 결과가 필요한 비동기 작업에 사용
      2. Supplier를 인자로 받으며, <T>를 return함.
  
## 연산 
    👉thenApply(Async) 

      1. 이전 처리의 결과가 이미 처리 된 상태라면 동기로 실행, 끝나지 않았다면 비동기로 실행
      (비동기로 실행하던 이전 처리 결과가 이미 처리 된 상태라면, 해당 로직을 실행시킨 thread가 받아서 실행하는 부분을 동기로 봄.)
    
      2. 처리 결과를 다음 단계로 전달 

      3. thenApply 시 현재 스레드에서 작업진행, thenApplyAsync 는 새로운 thread에서 작업진행
      
    👉 thenAccept(Asnyc)

      1. 이전 처리의 결과를 소비하고 새로운 로직을 추가 수행한다.
      2. 처리 결과를 다음단계로 전달 할 수 없음.

    👉 thenRun(Asnyc)

      1. 이전 처리 결과를 무시하고 새로운 로직을 수행한다.
      2. 작업이 끝난 후 이전 처리결과와 상관없이 로직을 지속해서 수행할 떄 사용.

    👉 thenCompose(Asnyc)

      1. 작업이 완료 된 CompletableFuture의 반환 값으로 다음 작업 수행. 연속적인 비동기 작업 실행
      2. 새로운 CompletableFuture 객체로 반환


    👉 thenCombine(Asnyc)

      1. 비동기 작업 두개를 병렬로 실행.
      2. 두개의 작업 후 하나의 return값을 반환.

    👉 allOf

      1. 여러개의 비동기 작업을 한번에 실행 (Executor의 invokeAll와 동일)
      2. 여러개의 비동기 값을 조합하여 이용할 때 사용

    👉 anyOf

      1. 여러개의 비동기 작업 중 하나만 실행 (Executor의 invokeAny 동일)


## 예외처리

    👉 Exceptionally(Async)

      1. 예외 발생 시 해당 예외를 처리하고, 새로운 값이나 대체 예외로 반환할 수 있음.

    👉 Hadle(Async)
      1. 결과와 예외처리를 둘 다 받을 수 있는 메서드
      2. 첫 번쨰 인수 값은 성공 시 반환값 ,두 번째 인수 값은 실패 시 반환값을 받는다.
      
    👉 WhenComplete(Async)
      1. handle과 같이 예외처리를 둘 다 받을 수 있는 메서드
      2. exception이 있을 때 예외처리를 넘겨주지 않으며, 후처리를 위해 사용하고, 예외처리는 따로 설정해주어야함.

      Async를 미사용 시 기존 thread에서 처리, 사용 시 새로운 thread에서 처리 


## 완료처리

     👉 Complete
         
       1. 강제적으로 값을 직접 저장해서 해당 completableFuture를 완료하고자 할 떄 사용
   
      👉 CompletedFuture

       1. 비동기 작업을 수행하지 않고 미리 계산 된 결과를 반환받을 떄 사용

      👉 CompleteOnTimeout

       1. 특정 반환 값과 시간 설정 후 특정 시간동안 작업이 종료되지 않으면 특정 반환값을 반환    

      👉 isCompletedExceptionally

       1. 예외로 인한 종료를 했을 때 true or false를 반환해줌

## 완료되지 않은 completableFuture
    1. 완료되지 않은 completableFuture가 있다면 무한대기, result 또는 AltResult를 반환해줘야함. 

 ***
 ***
# STREAM

   1. 다운스트림 컬렉터는 groupingBy(), partitioningBy() 후 추가적인 연산을 위해 사용



 

