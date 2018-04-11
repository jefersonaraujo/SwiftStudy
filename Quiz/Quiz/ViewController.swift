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
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let q0a1 = Answer(answer:"120 anos", isCorrect:true)
        let q0a2 = Answer(answer:"80 anos", isCorrect:false)
        let q0a3 = Answer(answer:"140 anos", isCorrect:false)
        let q0a4 = Answer(answer:"100 anos", isCorrect:false)
        
        let q0 = Question(question:"Quantos anos vive um elefante africano?",strImageFileName:"Elefante",
                          answers:[q0a1,q0a2,q0a3,q0a4])
        question = [q0]
        ShowQuestion(qid:0)
        
    }

    
   
        
        
    
    
  
    
    
    func ShowQuestion(qid : Int){
        lbQuestion.text = question[qid].strQuestion
        imgQuestion.image = question[qid].imgQuestion
        btAnswer1.setTitle(question[qid].answers[0].strAnswer,for: .normal)
        btAnswer2.setTitle(question[qid].answers[1].strAnswer,for: .normal)
        btAnswer3.setTitle(question[qid].answers[2].strAnswer,for: .normal)
        btAnswer4.setTitle(question[qid].answers[3].strAnswer,for: .normal)
        
    }
    
}

