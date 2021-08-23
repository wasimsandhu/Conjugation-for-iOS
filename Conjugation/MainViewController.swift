//
//  MainViewController.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 3/25/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import UIKit

var forms = ["Yo", "Tú", "Él/ella/usted", "Nosotros", "Vosotros", "Ellos/ellas/ustedes"]

class MainViewController: UIViewController, UITextFieldDelegate, UIPickerViewDelegate, UIPickerViewDataSource, UITableViewDelegate, UITableViewDataSource {
        
    var mainViewController: MainViewController?
    let conjugate = Conjugate()
    
    @IBOutlet weak var mainTextField: UITextField!
    @IBOutlet weak var tenseSelection: UIButton!
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet var table: UITableView!
        
    var frame: CGRect!
    
    var input: String?
    
    let tenses = ["Present Tense", "Preterite Tense", "Imperfect Tense", "Future Tense", "Imperative Tense", "Negative Imperative Tense", "Present Subjunctive Tense", "Imperfect Subjunctive Tense", "Conditional Tense"]
    
    var isInfinitive = false
    
    var cell: CustomCell!
    
    var currentTense: String?
    
    var autoCompleteVerbs = [String]()
    @IBOutlet weak var autoCompleteTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        mainTextField.delegate = self
        conjugate.mainViewController = self
        
        UITextField.appearance().tintColor = UIColor.white
        
        if (!picker.isHidden) {
            picker.isHidden = true
        }
        
        frame = self.mainTextField.frame;
        frame.size.width = 10000;
        self.mainTextField.frame = frame;
        
        mainTextField.attributedPlaceholder = NSAttributedString(string: "Write the infinitive here!", attributes: [NSAttributedStringKey.foregroundColor:UIColor.white])
        
        picker.delegate = self
        picker.dataSource = self
        
        picker.selectRow(0, inComponent: 0, animated: true)
        
        self.table.backgroundColor = UIColor.groupTableViewBackground
        
        autoCompleteTableView.isScrollEnabled = true
        autoCompleteTableView.isHidden = true
        
        UITabBarItem.appearance().titlePositionAdjustment = UIOffset(horizontal: 0, vertical: -10)
    }

    /* PICKERVIEW SETUP */
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return tenses.count
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        tenseSelection.setTitle(tenses[row], for: UIControlState())
        
        currentTense = tenses[row]
        
        readyToConjugate()
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return tenses[row]
    }
    
    @IBAction func showPickerView(_ sender: UIButton) {
        if (picker.isHidden) {
          picker.isHidden = false
        }
    }
    
    /* TABLE VIEW SETUP */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        var count: Int?
        
        if tableView == self.table {
            count = 6
        } else if tableView == self.autoCompleteTableView {
            count = autoCompleteVerbs.count
        }
        
        return count!
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        var cell: CustomCell?
        
        if tableView == self.table {
            cell = self.table.dequeueReusableCell(withIdentifier: "cell", for: indexPath) as? CustomCell
            
            cell!.formLabel.text = forms[(indexPath as NSIndexPath).row]
            
            if (self.conjugate.infinitive != nil) {
                if ((indexPath as NSIndexPath).row == 0) {
                    cell!.conjugatedVerb.text = conjugate.conjugationYo
                } else if ((indexPath as NSIndexPath).row == 1) {
                    cell!.conjugatedVerb.text = conjugate.conjugationTu
                } else if ((indexPath as NSIndexPath).row == 2) {
                    cell!.conjugatedVerb.text = conjugate.conjugationEl
                } else if ((indexPath as NSIndexPath).row == 3) {
                    cell!.conjugatedVerb.text = conjugate.conjugationNos
                } else if ((indexPath as NSIndexPath).row == 4) {
                    cell!.conjugatedVerb.text = conjugate.conjugationVos
                } else if ((indexPath as NSIndexPath).row == 5) {
                    cell!.conjugatedVerb.text = conjugate.conjugationEllos
                }
            } else {
                cell!.conjugatedVerb.text = " "
            }
        } else if tableView == self.autoCompleteTableView {
            cell = self.autoCompleteTableView.dequeueReusableCell(withIdentifier: "autoCompleteRowIdentifier3", for: indexPath) as? CustomCell
            let index = (indexPath as NSIndexPath).row as Int
            cell!.autoCompleteVerbLabel2.text = autoCompleteVerbs[index]
        }
        
        return cell!
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        
        var header: String?
        
        if tableView == self.autoCompleteTableView {
            header = "Verbs"
        } else if tableView == self.table {
            header = "Conjugations"
        }
        
        return header!
        
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if tableView == autoCompleteTableView {
            let selectedCell = autoCompleteTableView.cellForRow(at: indexPath) as! CustomCell
            mainTextField.text = selectedCell.autoCompleteVerbLabel2.text
            textFieldShouldReturn(mainTextField)
        } else {
            tableView.deselectRow(at: indexPath, animated: true)
        }
    }
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        mainTextField.attributedPlaceholder = NSAttributedString(string: "")
    }
    

    /* TEXT FIELD SETUP */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        input = self.mainTextField.text
        autoCompleteTableView.isHidden = true
        textField.resignFirstResponder()
        
        if (currentTense == nil) {
            currentTense = "Present Tense"
        }
        
        readyToConjugate()
        return true
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        autoCompleteTableView.isHidden = false
        let substring = (textField.text! as NSString).replacingCharacters(in: range, with: string)
        searchAutocompleteEntriesWithSubstring(substring)
        return true
    }
    
    func searchAutocompleteEntriesWithSubstring(_ substring: String) {
        autoCompleteVerbs.removeAll(keepingCapacity: false)
        
        for curString in verbs {
            let myString:NSString! = curString as NSString
            let substringRange :NSRange! = myString.range(of: substring)
            
            if (substringRange.location  == 0) {
                autoCompleteVerbs.append(curString)
            }
        }
        
        autoCompleteTableView.reloadData()
    }
    
    func readyToConjugate() {
        
        if (self.mainTextField.text!.hasSuffix("ar")) { isInfinitive = true }
        if (self.mainTextField.text!.hasSuffix("er")) { isInfinitive = true }
        if (self.mainTextField.text!.hasSuffix("ir")) { isInfinitive = true }
        if (self.mainTextField.text!.hasSuffix("ír")) { isInfinitive = true }
                
        let seconds = 0.1
        let delay = seconds * Double(NSEC_PER_SEC)  // nanoseconds per seconds
        let dispatchTime = DispatchTime.now() + Double(Int64(delay)) / Double(NSEC_PER_SEC)
        
        DispatchQueue.main.asyncAfter(deadline: dispatchTime, execute: {
            self.picker.isHidden = true
            if (self.isInfinitive) {
                self.conjugate.conjugate()
            } else if (self.input == "trisha") {
                self.conjugate.conjugate()
            } else {
                let alert = UIAlertController(title: "No verb inputted", message: "Please enter a verb to conjugate", preferredStyle: UIAlertControllerStyle.alert)
                alert.addAction(UIAlertAction(title: "Okay", style: UIAlertActionStyle.default, handler: nil))
                self.present(alert, animated: true, completion: nil)
            }
        })
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let DestinationVC: LearnViewController = segue.destination as! LearnViewController
        DestinationVC.tense = currentTense
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
}

