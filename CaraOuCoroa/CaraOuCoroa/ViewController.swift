//
//  ViewController.swift
//  CaraOuCoroa
//
//  Created by ios on 16/05/18.
//  Copyright © 2018 Ineesolutions.com.br. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var btnJogar: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func Jogar(_ sender: Any) {
        let numero:Int = Int(arc4random_uniform(2))
        print(numero)

    }
    
}

