//
//  ViewController.swift
//  Quiz
//
//  Created by ios on 06/09/17.
//  Copyright © 2017 Rose. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lbQuestion: UILabel!
    @IBOutlet weak var imgQuestion: UIImageView!
    @IBOutlet weak var btnAnswer1: UIButton!
    @IBOutlet weak var btnAnswer2: UIButton!
    @IBOutlet weak var btnAnswer3: UIButton!
    @IBOutlet weak var btnAnswer4: UIButton!
    
    @IBOutlet weak var viewFeedback: UIView!
    @IBOutlet weak var lbFeedback: UILabel!
    @IBOutlet weak var btnFeedback: UIButton!
    
    var questions : [Question]!
    var currentQuestion = 0
    var grade = 0.0
    var quizEnded = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.

        let q0answer0 = Answer(answer: "300", isCorrect: true)
        let q0answer1 = Answer(answer: "1", isCorrect: true)
        let q0answer2 = Answer(answer: "377", isCorrect: true)
        let q0answer3 = Answer(answer: "1200", isCorrect: true)
        let question0 = Question(question: "Até a 15 temporada, quantos (d oh!) Homer disse?", strImageFileName: "homer-doh", answers: [q0answer0,q0answer1,q0answer2,q0answer3])
        
        
        let q1answer0 = Answer(answer: "Flanders", isCorrect: true)
        let q1answer1 = Answer(answer: "Abraham", isCorrect: true)
        let q1answer2 = Answer(answer: "Frank", isCorrect: true)
        let q1answer3 = Answer(answer: "Stanley", isCorrect: true)
        let question1 = Question(question: "Qual o nome do pai do Homer?", strImageFileName: "pai-homer", answers: [q1answer0,q1answer1,q1answer2,q1answer3])
        
        let q2answer0 = Answer(answer: "Bartholomew", isCorrect: true)
        let q2answer1 = Answer(answer: "Bola de neve IV", isCorrect: true)
        let q2answer2 = Answer(answer: "Coltrane", isCorrect: true)
        let q2answer3 = Answer(answer: "Ajudante de papai noel", isCorrect: true)
        let question2 = Question(question: "Como os personagens chamam 'bola de neve IV'? ", strImageFileName: "Coltrane", answers: [q2answer0,q2answer1,q2answer2,q2answer3])
        
        let q3answer0 = Answer(answer: "Love joy", isCorrect: true)
        let q3answer1 = Answer(answer: "Flanders", isCorrect: true)
        let q3answer2 = Answer(answer: "Moe", isCorrect: true)
        let q3answer3 = Answer(answer: "Patty Bouvier", isCorrect: true)
        let question3 = Question(question: "Qual personagem é gay", strImageFileName: "personagens", answers: [q3answer0,q3answer1,q3answer2,q3answer3])
        
        let q4answer0 = Answer(answer: "Pendlefon Ward", isCorrect: true)
        let q4answer1 = Answer(answer: "Stan Lee", isCorrect: true)
        let q4answer2 = Answer(answer: "Alex Hirsch", isCorrect: true)
        let q4answer3 = Answer(answer: "Matt Groening", isCorrect: true)
        let question4 = Question(question: "Quem é o criador da série?", strImageFileName: "criador", answers: [q4answer0,q4answer1,q4answer2,q4answer3])
        
        let q5answer0 = Answer(answer: "Os pesadelos de Springfield", isCorrect: true)
        let q5answer1 = Answer(answer: "Casa da arvore dos horrores", isCorrect: true)
        let q5answer2 = Answer(answer: "Nao tem especial de Halloween", isCorrect: true)
        let q5answer3 = Answer(answer: "Os Simpsons Halloween", isCorrect: true)
        let question5 = Question(question: "Qual o nome dos episódios especiais de 'Halloween' ?", strImageFileName: "halloween", answers: [q5answer0,q5answer1,q5answer2,q5answer3])
        
        let q6answer0 = Answer(answer: "Maggie jo-jo Simpson", isCorrect: true)
        let q6answer1 = Answer(answer: "Margaret Bouvier jo-jo Simpson", isCorrect: true)
        let q6answer2 = Answer(answer: "Maggie Simpson", isCorrect: true)
        let q6answer3 = Answer(answer: "Maggie jay Simpson", isCorrect: true)
        let question6 = Question(question: "Qual o nome completo da Maggie?", strImageFileName: "maggie", answers: [q6answer0,q6answer1,q6answer2,q6answer3])
        
        let q7answer0 = Answer(answer: "1 ano", isCorrect: true)
        let q7answer1 = Answer(answer: "6 meses", isCorrect: true)
        let q7answer2 = Answer(answer: "1 semana", isCorrect: true)
        let q7answer3 = Answer(answer: "2 dias", isCorrect: true)
        let question7 = Question(question: "Quanto tempo leva para produzir cada episódio?", strImageFileName: "simpss", answers: [q7answer0,q7answer1,q7answer2,q7answer3])
        
        let q8answer0 = Answer(answer: "1 á 2 horas", isCorrect: true)
        let q8answer1 = Answer(answer: "5 a 46 segundos", isCorrect: true)
        let q8answer2 = Answer(answer: "3 á 5 minutos", isCorrect: true)
        let q8answer3 = Answer(answer: "15 á 20 segundos", isCorrect: true)
        let question8 = Question(question: "Quantos segundos demora a abertura do série?", strImageFileName: "abertura", answers: [q8answer0,q8answer1,q8answer2,q8answer3])
        
        let q9answer0 = Answer(answer: "França", isCorrect: true)
        let q9answer1 = Answer(answer: "Árabia", isCorrect: true)
        let q9answer2 = Answer(answer: "China", isCorrect: true)
        let q9answer3 = Answer(answer: "Brasil", isCorrect: true)
        let question9 = Question(question: "Em qual país que ao invés de beber cerveja, Homer bebe refrigerante?", strImageFileName: "bebendo", answers: [q9answer0,q9answer1,q9answer2,q9answer3])
        
        questions = [question0, question1, question2, question3, question4, question5, question6, question7, question8, question9]
        
        startQuiz()
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
    
    func showQuestion(questionid: Int){
        btnAnswer1.isEnabled = true
        btnAnswer2.isEnabled = true
        btnAnswer3.isEnabled = true
        btnAnswer4.isEnabled = true
        
        lbQuestion.text = questions[questionid].strQuestion
        imgQuestion.image = questions[questionid].imgQuestion
        
        btnAnswer1.setTitle(questions[questionid].answers[0].strAnswer, for: UIControlState.normal)
        btnAnswer2.setTitle(questions[questionid].answers[0].strAnswer, for: UIControlState.normal)
        btnAnswer3.setTitle(questions[questionid].answers[0].strAnswer, for: UIControlState.normal)
        btnAnswer4.setTitle(questions[questionid].answers[0].strAnswer, for: UIControlState.normal)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
        btnAnswer1.isEnabled = false
        btnAnswer2.isEnabled = false
        btnAnswer3.isEnabled = false
        btnAnswer4.isEnabled = false
        
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
    
    
    @IBAction func btnFeedbackAction(sender: AnyObject) {
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

