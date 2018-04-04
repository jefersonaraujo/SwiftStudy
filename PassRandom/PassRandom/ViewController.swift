//
//  ViewController.swift
//  PassRandom
//
//  Created by ios on 04/04/18.
//  Copyright © 2018 Ineesolutions.com.br. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBOutlet weak var key: UITextField!
    
    @IBOutlet weak var pass: UILabel!
    
    @IBAction func gerarSenha(_ sender: Any) {
        
        
        
        let a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890" + key.text!
        
        var senha = ""
        
        for _ in 0..<10
        {
            let r = Int(arc4random_uniform(UInt32(a.characters.count)))
            
            senha += String(a[a.index(a.startIndex, offsetBy: r)])
        }
        
        
        pass.text = String(senha)
        
        
        
    }
}

