//
//  PerfectTensesVC.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 3/25/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import UIKit

class PerfectTensesVC: UIViewController, UITextFieldDelegate, UIPickerViewDelegate, UIPickerViewDataSource, UITableViewDelegate, UITableViewDataSource {

    var perfectViewController: PerfectTensesVC?
    let perfect = ConjugatePerfect()
    
    @IBOutlet weak var perfectTextField: UITextField!
    @IBOutlet weak var perfectTable: UITableView!
    @IBOutlet weak var perfectPicker: UIPickerView!
    @IBOutlet weak var perfectTenseSelection: UIButton!
    
    let perfectTenses = ["Present Perfect Tense", "Past Perfect Tense", "Future Perfect Tense", "Present Perfect Subjunctive", "Past Perfect Subjunctive", "Conditional Perfect Tense"]
    
    var frame: CGRect!
    
    var input: String?
    
    var isInfinitive = false
    
    var currentPerfectTense: String?
    
    var autoCompleteVerbs = [String]()
    @IBOutlet weak var autoCompleteTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        perfectTextField.delegate = self
        perfect.perfectViewController = self
        
        if (!perfectPicker.isHidden) {
            perfectPicker.isHidden = true
        }
        
        frame = self.perfectTextField.frame;
        frame.size.width = 10000;
        self.perfectTextField.frame = frame;
        
        perfectTextField.attributedPlaceholder = NSAttributedString(string: "Write the infinitive here!", attributes: [NSAttributedStringKey.foregroundColor:UIColor.white])
        
        perfectPicker.delegate = self
        perfectPicker.dataSource = self
        
        perfectPicker.selectRow(0, inComponent: 0, animated: true)
        
        self.perfectTable.backgroundColor = UIColor.groupTableViewBackground
        
        autoCompleteTableView.isScrollEnabled = true
        autoCompleteTableView.isHidden = true
    }
    
    /* PICKERVIEW SETUP */
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return perfectTenses.count
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        perfectTenseSelection.setTitle(perfectTenses[row], for: UIControlState())
        currentPerfectTense = perfectTenses[row]
        readyToConjugate()
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return perfectTenses[row]
    }
    
    @IBAction func showPicker(_ sender: UIButton) {
        if (perfectPicker.isHidden) {
            perfectPicker.isHidden = false
        }
    }
    
    
    /* TABLE VIEW SETUP */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        var count: Int?
        
        if tableView == self.perfectTable {
            count = 6
        } else if tableView == self.autoCompleteTableView {
            count = autoCompleteVerbs.count
        }
        
        return count!
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        var cell: CustomCell?
        
        if tableView == self.perfectTable {
            
            cell = self.perfectTable.dequeueReusableCell(withIdentifier: "cell2", for: indexPath) as? CustomCell
            
            cell!.formLabel2.text = forms[(indexPath as NSIndexPath).row]
            
            if (self.perfect.infinitive != nil) {
                if ((indexPath as NSIndexPath).row == 0) {
                    cell!.perfectVerb.text = perfect.conjugationYo
                } else if ((indexPath as NSIndexPath).row == 1) {
                    cell!.perfectVerb.text = perfect.conjugationTu
                } else if ((indexPath as NSIndexPath).row == 2) {
                    cell!.perfectVerb.text = perfect.conjugationEl
                } else if ((indexPath as NSIndexPath).row == 3) {
                    cell!.perfectVerb.text = perfect.conjugationNos
                } else if ((indexPath as NSIndexPath).row == 4) {
                    cell!.perfectVerb.text = perfect.conjugationVos
                } else if ((indexPath as NSIndexPath).row == 5) {
                    cell!.perfectVerb.text = perfect.conjugationEllos
                }
            } else {
                cell!.perfectVerb.text = " "
            }
        } else if tableView == self.autoCompleteTableView {
            cell = self.autoCompleteTableView.dequeueReusableCell(withIdentifier: "autoCompleteRowIdentifier2", for: indexPath) as? CustomCell
            let index = (indexPath as NSIndexPath).row as Int
            cell!.autoCompleteVerbLabel3.text = autoCompleteVerbs[index]
        }
        
        return cell!
    }
    
    
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        var header: String?
        
        if tableView == self.autoCompleteTableView {
            header = "Verbs"
        } else if tableView == self.perfectTable {
            header = "Perfect Conjugations"
        }
        
        return header!
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if tableView == autoCompleteTableView {
            let selectedCell = autoCompleteTableView.cellForRow(at: indexPath) as! CustomCell
            perfectTextField.text = selectedCell.autoCompleteVerbLabel3.text
            textFieldShouldReturn(perfectTextField)
        } else {
            tableView.deselectRow(at: indexPath, animated: true)
        }
    }
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        perfectTextField.attributedPlaceholder = NSAttributedString(string: "")
    }
    
    /* KEYBOARD HIDE */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        input = self.perfectTextField.text
        autoCompleteTableView.isHidden = true
        textField.resignFirstResponder()
        
        if (currentPerfectTense == nil) {
            currentPerfectTense = "Present Perfect Tense"
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
        if (self.perfectTextField.text!.hasSuffix("ar")) { isInfinitive = true }
        if (self.perfectTextField.text!.hasSuffix("er")) { isInfinitive = true }
        if (self.perfectTextField.text!.hasSuffix("ir")) { isInfinitive = true }
        if (self.perfectTextField.text!.hasSuffix("ír")) { isInfinitive = true }
        
        let seconds = 0.1
        let delay = seconds * Double(NSEC_PER_SEC)  // nanoseconds per seconds
        let dispatchTime = DispatchTime.now() + Double(Int64(delay)) / Double(NSEC_PER_SEC)
        
        DispatchQueue.main.asyncAfter(deadline: dispatchTime, execute: {
            self.perfectPicker.isHidden = true
            if (self.isInfinitive) {
                self.perfect.prepareForConjugate()
            } else {
                let alert = UIAlertController(title: "No verb inputted", message: "Please enter a verb to conjugate", preferredStyle: UIAlertControllerStyle.alert)
                alert.addAction(UIAlertAction(title: "Okay", style: UIAlertActionStyle.default, handler: nil))
                self.present(alert, animated: true, completion: nil)
            }
        })
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let DestinationVC: LearnViewController = segue.destination as! LearnViewController
        DestinationVC.tense = currentPerfectTense
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

