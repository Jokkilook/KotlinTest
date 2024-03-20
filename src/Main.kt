fun main() {
    val question = Question()

    question.question1()
    question.question2()
    question.question3()
    question.question4()
    question.question5()
    question.question6()
}

class Question {
    fun question1() {
        /*
        문제 1: 리스트에서 짝수만 필터링하기
        주어진 정수 리스트에서 짝수만을 추출하여 새 리스트로 반환하는 함수를 작성하세요.
         */
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val resultList = mutableListOf<Int>()
        list.map { if(it%2==0){ //map 함수 for( item in list) 처럼 리스트의 요소를 하나씩 반환한다. it 으로 반환함.
            resultList.add(it)
        } }

        println(resultList)
    }

    fun question2() {
        /*
        문제 2: 이름의 목록에서 길이가 5보다 큰 이름 찾기
        주어진 이름의 목록에서 길이가 5보다 큰 첫 번째 이름을 찾아 반환하는 함수를 작성하세요. 해당하는 이름이 없으면 "Not found"를 반환하세요.
         */
        val list = listOf("Kotlin", "Java", "C++", "JavaScript", "Python")
        val resultList = mutableListOf<String>()

        list.map { if(it.length>5){
            resultList.add(it)
            }
        }

        if(resultList.isEmpty()){
            println("Not Found")
            return
        }

        println(resultList)
    }

    fun question3() {
        /*
        문제 3: null이 포함될 수 있는 리스트에서 최대값 찾기
        null이 포함될 수 있는 정수 리스트에서 최대값을 찾아 반환하는 함수를 작성하세요. 리스트가 null이거나 비었으면 null을 반환하세요.
         */
        val list = listOf(1, 2, 3, 4, 5, 6, null, 8, null, 10)
        println(list.filterNotNull().maxOrNull())

//        if(list.isNullOrEmpty()){println("null")}
//        var result = 0
//        list.map { if(it != null){
//            if(it>result){
//                result = it
//            }
//        } }
//
//        print(result)
    }

    fun question4() {
        /*
        문제 4: 사용자 입력 처리하기
        사용자로부터 받은 입력 문자열이 null이 아니고, "exit"가 아닐 때까지 계속 입력을 받아 그 내용을 출력하는 프로그램을 작성하세요.
        Tip: readLine() 함수를 사용하여 사용자 입력을 받을 수 있습니다.
         */
        var input:String? = ""
        var state = true
        while(state){
            print("입력하세요. (종료하려면 'exit'나 빈칸 입력)>>")
            input = readLine()
            if(input.isNullOrEmpty()||input.equals("exit")){
                println("종료합니다.")
                state = false
            }
            else{
                println("입력값>> "+input)
            }
        }


    }

    fun question5() {
        /*
        문제 5: 리스트 변환하기
        주어진 User 객체의 리스트에서 각 사용자의 이름을 추출하여 새로운 리스트를 생성하되, 이름이 null이 아니고 3글자 이상인 사용자의 이름만 대문자로 변환하여 포함시키는 함수를 작성하세요.
         */
        val users = listOf(
            User("Kotlin", 31),
            User("Java", 20),
            User(null, 25),
            User("C", 40),
            User("JS", 30),
            User("Python", 35)
        )
        var resultList = mutableListOf<String>()
        users.map { if(!it.name.isNullOrEmpty()&& it.name!!.length>=3){
            resultList.add(it.name!!.uppercase())
        } }

        println(resultList)

        val usersFilter =  users
            .filter { it.name!=null && it.name!!.length >= 3 }
            .map { it.name?.uppercase() }

        var usersFilters =  users
            .filter { it.name!=null && it.name!!.length >= 3 }
            .map { it.apply { this.name=this.name?.uppercase() } }

    }

    fun question6() {
        /*
        문제 6: 복잡한 조건의 데이터 처리
        주어진 Order 객체 리스트에서 isDelivered가 true인 주문을 찾고, 해당 주문의 products 리스트에서 price가 100 이상인 제품의 이름을 대문자로 변환하여 새 리스트를 생성하는 함수를 작성하세요.
         */
        val orders = listOf(
            Order(
                listOf(Product("Kotlin", 100), Product("Java", 80), Product("C", 60)),
                true
            ),
            Order(
                listOf(Product("JS", 120), Product("Python", 90), Product("C++", 110)),
                false
            ),
            Order(
                listOf(Product("C#", 70), Product("Swift", 130), Product("Go", 40)),
                true
            ),
            Order(
                listOf(Product("Ruby", 110), Product("R", 50), Product("Dart", 90)),
                false
            ),
            Order(
                listOf(Product("TypeScript", 100), Product("PHP", 80), Product("Scala", 120)),
                true
            )
        )

        var resultList = mutableListOf<String>()

        orders.map { if(it.isDelivered){
            it.list.map { if(it.price>=100){
                resultList.add(it.name.uppercase())
            } }
        } }
        println(resultList)
    }
}
//map filter apply