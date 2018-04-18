//
//  ViewController.swift
//  Quiz
//
//  Created by Ios on 06/04/2018.
//  Copyright © 2018 INeedSolutions. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {
    var question :[Question]!

    @IBOutlet weak var imgQuestion: UIImageView!    
    @IBOutlet weak var lbQuestion: UILabel!
    @IBOutlet weak var btAnswer1: UIButton!
    @IBOutlet weak var btAnswer2: UIButton!
    @IBOutlet weak var btAnswer3: UIButton!
    @IBOutlet weak var btAnswer4: UIButton!

    @IBOutlet weak var viewFeedback: UIView!
    
    @IBOutlet weak var btnFeedback: UIButton!
    
    @IBOutlet weak var lbFeedback: UILabel!
    
 
    var questions : [Question]!
    var currentQuestion = 0
    var grade = 0.0
    var quizEnded = false
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // let q0a1 = Answer(answer:"120 anos", isCorrect:true)
        // let q0a2 = Answer(answer:"80 anos", isCorrect:false)
        // let q0a3 = Answer(answer:"140 anos", isCorrect:false)
        // let q0a4 = Answer(answer:"100 anos", isCorrect:false)
        
        // let q0 = Question(question:"Quantos anos vive um elefante africano?",strImageFileName:"Elefante",
        //                   answers:[q0a1,q0a2,q0a3,q0a4])
        // question = [q0]
        // ShowQuestion(qid:0)
      let q0answer0 = Answer(answer: "60-70 anos", isCorrect: true)
        let q0answer1 = Answer(answer: "50 anos", isCorrect: false)
        let q0answer2 = Answer(answer: "30-40 anos", isCorrect: false)
        let q0answer3 = Answer(answer: "100 anos", isCorrect: false)
        let question0 = Question(question: "Quantos anos em média vive um elefante africano?", strImageFileName: "elefante", answers: [q0answer0,q0answer1,q0answer2,q0answer3])
        
        
        let q1answer0 = Answer(answer: "5,5 metros", isCorrect: true)
        let q1answer1 = Answer(answer: "3,5 metros", isCorrect: false)
        let q1answer2 = Answer(answer: "6,5 metros", isCorrect: false)
        let q1answer3 = Answer(answer: "4,5 metros", isCorrect: false)
        let question1 = Question(question: "Quantos metros em média tem uma girafa macho adulta?", strImageFileName: "girafa", answers: [q1answer0,q1answer1,q1answer2,q1answer3])
        
        let q2answer0 = Answer(answer: "3300 kg", isCorrect: false)
        let q2answer1 = Answer(answer: "2300 kg", isCorrect: false)
        let q2answer2 = Answer(answer: "3600 kg", isCorrect: true)
        let q2answer3 = Answer(answer: "1800 kg", isCorrect: false)
        let question2 = Question(question: "Quanto pesa em média um rinoceronte macho adulto? ", strImageFileName: "rinoceronte", answers: [q2answer0,q2answer1,q2answer2,q2answer3])
        
        let q3answer0 = Answer(answer: "44 km/h joy", isCorrect: false)
        let q3answer1 = Answer(answer: "50 km/h", isCorrect: false)
        let q3answer2 = Answer(answer: "80 km/h", isCorrect: false)
        let q3answer3 = Answer(answer: "64 km/h ", isCorrect: true)
        let question3 = Question(question: "Qual a velocidade de uma zebra?", strImageFileName: "zebra", answers: [q3answer0,q3answer1,q3answer2,q3answer3])
        
        let q4answer0 = Answer(answer: "Galápagos", isCorrect: false)
        let q4answer1 = Answer(answer: "Imperador", isCorrect: true)
        let q4answer2 = Answer(answer: "Azul", isCorrect: false)
        let q4answer3 = Answer(answer: "Rey", isCorrect: false)
        let question4 = Question(question: "O maior pinguim que existe é o ?", strImageFileName: "pinguim", answers: [q4answer0,q4answer1,q4answer2,q4answer3])
        
        let q5answer0 = Answer(answer: "AVES", isCorrect: false)
        let q5answer1 = Answer(answer: "MAMÍFEROS", isCorrect: true)
        let q5answer2 = Answer(answer: "PEIXES", isCorrect: true)
        let q5answer3 = Answer(answer: "RÉPTEIS", isCorrect: true)
        let question5 = Question(question: "O Morcego é uma especie de ?", strImageFileName: "morcego", answers: [q5answer0,q5answer1,q5answer2,q5answer3])
        
        let q6answer0 = Answer(answer: "10-20 Anos", isCorrect: false)
        let q6answer1 = Answer(answer: "5-12 Anos", isCorrect: false)
        let q6answer2 = Answer(answer: "40 Anos", isCorrect: false)
        let q6answer3 = Answer(answer: "25–30 Anos", isCorrect: true)
        let question6 = Question(question: "Quaĺ é a expectiva de vida de um carvalo?", strImageFileName: "carvalo", answers: [q6answer0,q6answer1,q6answer2,q6answer3])
        
        let q7answer0 = Answer(answer: "Guepardo", isCorrect: true)
        let q7answer1 = Answer(answer: "Tigre", isCorrect: false)
        let q7answer2 = Answer(answer: "Leão", isCorrect: false)
        let q7answer3 = Answer(answer: "Leopardo", isCorrect: false)
        let question7 = Question(question: "Qual é o animal terrestre mais rápido do mundo?", strImageFileName: "bolt", answers: [q7answer0,q7answer1,q7answer2,q7answer3])
        
        let q8answer0 = Answer(answer: "Misto", isCorrect: false)
        let q8answer1 = Answer(answer: "Quente", isCorrect: false)
        let q8answer2 = Answer(answer: "Frio", isCorrect: true)
        let q8answer3 = Answer(answer: "Morno", isCorrect: false)
        let question8 = Question(question: "Jacare é um animal de sangue...", strImageFileName: "jacare", answers: [q8answer0,q8answer1,q8answer2,q8answer3])
        
        let q9answer0 = Answer(answer: "Chimpanzé", isCorrect: false)
        let q9answer1 = Answer(answer: "Mico leão dourado", isCorrect: false)
        let q9answer2 = Answer(answer: "Zubumafu", isCorrect: false)
        let q9answer3 = Answer(answer: "Lêmure", isCorrect: true)
        let question9 = Question(question: "Qual o nome desse animal ?", strImageFileName: "zubumafu", answers: [q9answer0,q9answer1,q9answer2,q9answer3])
        
        questions = [question0, question1, question2, question3, question4, question5, question6, question7, question8, question9]
        
       startQuiz()

        
    }
    
    @IBAction func chooseAnswer1(_ sender: Any) {
        selectAnswer(answerid: 0)

    }
    
    @IBAction func chooseAnswer2(_ sender: Any) {
        selectAnswer(answerid: 1)

    }
    
    @IBAction func chooseAnswer3(_ sender: Any) {
        selectAnswer(answerid: 2)

    }
    @IBAction func chooseAnswer4(_ sender: Any) {
        selectAnswer(answerid: 3)

    }
    
    func  selectAnswer(answerid: Int){
        btAnswer1.isEnabled = false
        btAnswer2.isEnabled = false
        btAnswer3.isEnabled = false
        btAnswer4.isEnabled = false
        
        viewFeedback.isHidden = false
        
        let answer: Answer = questions[currentQuestion].answers[answerid]
        
        if(answer.isCorrect == true){
            grade = grade + 1.0
            lbFeedback.text = answer.strAnswer + "\n\nResposta correta!"
        }else{
            lbFeedback.text = answer.strAnswer + "\n\nResposta errada..."
        }
        if(currentQuestion < questions.count-1){
            btnFeedback.setTitle("Próxima", for: UIControlState.normal)
        }else{
            btnFeedback.setTitle("Ver Nota", for: UIControlState.normal)
        }
    }
    
    
        func startQuiz(){
        questions.shuffle()
        for i in 0 ..< questions.count{
            questions[i].answers.shuffle()
        }
        quizEnded = false
        grade = 0.0
        currentQuestion = 0

        showQuestion(questionid: 0)
    }
//
    func showQuestion(questionid: Int){

        btAnswer1.isEnabled = true
        btAnswer2.isEnabled = true
        btAnswer3.isEnabled = true
        btAnswer4.isEnabled = true

        lbQuestion.text = questions[questionid].strQuestion
        imgQuestion.image = questions[questionid].imgQuestion

        btAnswer1.setTitle(questions[questionid].answers[0].strAnswer, for: UIControlState.normal)
        btAnswer2.setTitle(questions[questionid].answers[1].strAnswer, for: UIControlState.normal)
        btAnswer3.setTitle(questions[questionid].answers[2].strAnswer, for: UIControlState.normal)
        btAnswer4.setTitle(questions[questionid].answers[3].strAnswer, for: UIControlState.normal)

    }
    
    
    @IBAction func btnFeedbackAction(_ sender: Any) {
        viewFeedback.isHidden = true
        
        if(quizEnded){
            startQuiz()
        }else{
            nextQuestion()
        }
    }
    
    
    func nextQuestion(){
    currentQuestion += 1
    
    if(currentQuestion < questions.count){
    showQuestion(questionid: currentQuestion)
    }else{
    endQuiz()
    }
    }
    
    func endQuiz(){
        grade = grade / Double(questions.count) * 100.0
        quizEnded = true
        viewFeedback.isHidden = false
        lbFeedback.text = "Sua nota: \(grade)"
        btnFeedback.setTitle("Refazer", for: UIControlState.normal)
        
        
    }


}
    


