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

    

    @IBAction func gerarNumero(_ sender: Any) {
        let numeroAleatorio = arc4random_uniform(11)
        textoResultado.text = String(numeroAleatorio)
        
        let urlString = URL(string: "http://jsonplaceholder.typicode.com/users/1")
        if let url = urlString {
            let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
                if error != nil {
                    print(error)
                } else {
                    if let usableData = data {
                        print(usableData) //JSONSerialization
                    }
                }
            }
        }    }

}

