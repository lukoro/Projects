using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{
    public GameObject rulesPanel;
    public void PlayGame()
    {
        SceneManager.LoadScene("MainMenu"); 
    }

    public void QuitGame()
    {
        Debug.Log("Hra byla ukonèena!");
        Application.Quit();
    }

    // Metoda pro zobrazení pravidel
    public void ShowRules()
    {
        rulesPanel.SetActive(true);
    }

    // Metoda pro zavøení pravidel
    public void HideRules()
    {
        rulesPanel.SetActive(false);
    }
}
