//
//  ViewController.swift
//  GeradorDeNumeros
//
//  Created by IOS on 16/03/18.
//  Copyright © 2018 IneedSolutions. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {
    


    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
        @IBOutlet weak var textoResultado: UILabel!
        @IBOutlet weak var key: UITextField!
    
    

    

    @IBAction func gerarNumero(_ sender: Any) {
       
        let a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890" + key.text!
        
        var senha = ""
        
        for _ in 0..<10
        {
            let r = Int(arc4random_uniform(UInt32(a.characters.count)))
            
            senha += String(a[a.index(a.startIndex, offsetBy: r)])
        }

        
        textoResultado.text = String(senha)
        
        
        
       }

}

