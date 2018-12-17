function variasQuestoes() {
    var url = baseUrl + "/questions/"
    function QuestaoObj(question, a, b, c, d, e, maxtime, correct) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.maxtime = maxtime;
        this.correct = correct; 
     }
     
     //cadastroQuestaoAjax(url, new QuestaoObj());
}
