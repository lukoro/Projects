using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class ResetPosition : MonoBehaviour
{
    public Vector2 startPosition;
    [SerializeField] public float resetTime;
    private float timeRemaining;
    public Text timerText;
    public Text levelCounter;
    public int level = 1;
    public int currentLevel;
    public float quitTimer = 4f;

    public ArrowTrap arrowTrap;


    public GameObject Saw;
    public GameObject GroundApp;
    public GameObject GroundDisa;
    public GameObject ArrowHolder;
    public GameObject Platform;
    public GameObject Apper2;
    public GameObject Spikes;
    public GameObject QuitMenu;
    public GameObject Level;
    public GameObject MainMenu;

    void Start()
    {
        startPosition = transform.position;
        timeRemaining = resetTime;
        currentLevel = level;

    //    InvokeRepeating("ResetPosit", resetTime, resetTime);
    }

    // Update is called once per frame
    void Update()
    {

        timeRemaining -= Time.deltaTime;
        if (timeRemaining < 0)
        {
            timeRemaining = resetTime;
            transform.position = startPosition;
        }
        if (UnityEngine.Input.GetKey(KeyCode.Space))
        {
            timeRemaining = resetTime;
            transform.position = startPosition;
        }

        if (timerText != null)
            timerText.text = "Time Left: " + Mathf.Ceil(timeRemaining).ToString();

        if (levelCounter != null)
            levelCounter.text = "Round: " + level.ToString();

    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "Checkpoint")
        {
            transform.position = startPosition;
            switch (level)
            {
                case 1:
                    Saw.SetActive(true);
                    break;
                case 2:
                    GroundApp.SetActive(true);
                    Spikes.SetActive(true);
                    break;
                case 3:
                    GroundDisa.SetActive(false);
                    break;
                case 4:
                    ArrowHolder.SetActive(true);
                    break;
                case 5:
                    arrowTrap.attackCooldown -= 1;
                    break;
                case 6:
                    arrowTrap.attackCooldown -= (float)0.5;
                    break;
                case 7:
                    Apper2.SetActive(true);
                    Platform.SetActive(true);
                    break;
                case 8:
                    QuitMenu.SetActive(true);
                    Level.SetActive(false);

                    Invoke("QuitGame", 4f);

                    break;
                default:
                    break;
            }
            level++;
            resetTime++;
            timeRemaining = resetTime;

        }

        if (collision.gameObject.tag == "Saw" || collision.gameObject.tag == "ArrowHolder")
        {
            timeRemaining = resetTime;
            transform.position = startPosition;
        }
    }

    void QuitGame()
    {
        Application.Quit();
    }


    void ResetPosit()
    {
        timeRemaining = resetTime;
        transform.position = startPosition;
    }

}
