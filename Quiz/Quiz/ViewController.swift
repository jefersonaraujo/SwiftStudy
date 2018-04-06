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
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        let q0a1 = Answer(answer:"120 anos", isCorrect:true)
        let q0a2 = Answer(answer:"80 anos", isCorrect:false)
        let q0a3 = Answer(answer:"140 anos", isCorrect:false)
        let q0a4 = Answer(answer:"100 anos", isCorrect:false)
        
        let q0 = Question(question:"Quantos anos vive um elefante africano?", strImageFileName:"Elefante", answers:[q0a1,q0a2,q0a3,q0a4])
        question = [q0]
        //ShowQuestion(0)
        
    }
    

    

}

