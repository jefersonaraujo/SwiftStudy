//
//  QuizModel.swift
//  Quiz
//
//  Created by Ios on 06/04/2018.
//  Copyright © 2018 INeedSolutions. All rights reserved.
//

import UIKit
import Foundation

class Question {
    
    var strQuestion :String!
    var imgQuestion :UIImage!
    var answers : [Answer]!
    
    init(question:String, strImageFileName:String, answers:[Answer]){
        
        self.strQuestion = question
        self.imgQuestion = UIImage(named:strImageFileName)
        self.answers = answers
    }
    
}

class Answer {
    
    var strAnswer:String!
    var isCorrect:Bool!
    
    init(answer:String, isCorrect: Bool) {
        
        self.strAnswer = answer
        self.isCorrect = isCorrect
    }
    
}
